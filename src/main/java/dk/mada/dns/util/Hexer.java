package dk.mada.dns.util;

import java.nio.ByteBuffer;
import java.util.Optional;

import dk.mada.dns.wire.model.DnsRequest;

public class Hexer {
	private Hexer() {}
	
	public static String toHexLine(ByteBuffer bb) {
		int pos = bb.position();
		bb.rewind();
		StringBuilder sb = new StringBuilder();
		while (bb.hasRemaining()) {
			byte b = bb.get();
			if (Byte.toUnsignedInt(b) >= 128) {
				sb.append("(byte)");
			}
			sb.append(String.format("0x%02x, ", b));
		}
		bb.position(pos);
		return sb.toString();
	}

	public static String toHexBlock(Optional<ByteBuffer> bb) {
		return bb.map(b -> toHexBlock("", b))
				.orElse("<No data>");
	}
	
	public static String toHexBlock(String prefix, ByteBuffer bb) {
		int pos = bb.position();
		bb.rewind();
		StringBuilder sb = new StringBuilder();
		int i = 0;
		StringBuilder ascii = new StringBuilder();
		while (bb.hasRemaining()) {
			if (i % 16 == 0) {
				sb.append(prefix).append(String.format("0x%04x", i));
			}
			if (i % 8 == 0) {
				sb.append(' ');
			}
			byte b = bb.get();
			i++;
			sb.append(String.format("%02x ", b));
			int bint = Byte.toUnsignedInt(b);
			ascii.append(bint >= 32 && bint < 127 ? (char)b : ".");
			if (i % 16 == 0) {
				sb.append(ascii.toString());
				ascii = new StringBuilder();
				sb.append("\n");
			}
		}
		
		if (i % 16 != 0) {
			while (i % 16 != 0) {
				sb.append("   ");
				i++;
			}
			sb.append(ascii);
		}

		bb.position(pos);
		return sb.toString().replaceAll("\n$", "");
	}
	
	public static String hexPosition(ByteBuffer bb) {
		return hexShort(bb.position());
	}

	public static String hexShort(int offset) {
		return String.format("0x%04x", offset);
	}

	public static void printForDevelopment(DnsRequest request) {
		String title = "Request " + request.getQuestion().getName().getName() + " : " + hexShort(request.getHeader().getFlags());
		printForDevelopment(title, request.asWirePacket());
	}
	
	public static void printForDevelopment(String title, ByteBuffer bb) {
		System.out.println("/* " + title);
		System.out.println(toHexBlock(" * ", bb));
		System.out.println(" */");
		System.out.println("byte[] req = new byte[] {" + toHexLine(bb) + "};");
	}
}