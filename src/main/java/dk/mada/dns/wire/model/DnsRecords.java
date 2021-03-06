package dk.mada.dns.wire.model;

import java.io.UncheckedIOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

public class DnsRecords {

	public static DnsRecordA aRecordFrom(DnsName name, InetAddress address, long ttl) {
		return new DnsRecordA(name, address, ttl);
	}

	public static DnsRecordA aRecordBlindFrom(DnsName name, long ttl) {
		try {
			return new DnsRecordA(name, InetAddress.getByAddress(new byte[] { 0, 0, 0, 0}), ttl);
		} catch (UnknownHostException e) {
			throw new UncheckedIOException(e);
		}
	}

	public static DnsRecordAAAA aaaaRecordFrom(DnsName name, InetAddress address, long ttl) {
		return new DnsRecordAAAA(name, address, ttl);
	}

	public static DnsRecordC cRecordFrom(DnsName name, DnsName aliasName, long ttl) {
		return new DnsRecordC(name, aliasName, ttl);
	}
	
	public static DnsRecordQ qRecordFrom(DnsName name, DnsRecordType type) {
		return new DnsRecordQ(name, type);
	}
	
	public static DnsRecordOpt optRecordFrom(DnsName name, DnsRecordType type, short payloadSize, byte xrcode,  byte version, short flags, List<DnsOption> options) {
		return new DnsRecordOpt(name, type, payloadSize, xrcode, version, flags, options);
	}
	
	public static DnsRecordTxt txtRecordFrom(DnsName name, DnsClass dnsClass, long ttl, List<String> txts) {
		return new DnsRecordTxt(name, dnsClass, ttl, txts);
	}
}
