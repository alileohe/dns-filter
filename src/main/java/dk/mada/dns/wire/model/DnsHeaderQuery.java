package dk.mada.dns.wire.model;

import dk.mada.dns.util.Hexer;

public class DnsHeaderQuery extends DnsHeader {
	public DnsHeaderQuery(short id, short flags, short qdcount, short ancount, short nscount, short arcount) {
		super(id, flags, qdcount, ancount, nscount, arcount);
		
		if ((flags & 0x8000) == 0) {
			throw new IllegalStateException("Not a query header with flags " + Hexer.hexShort(flags));
		}
	}

}