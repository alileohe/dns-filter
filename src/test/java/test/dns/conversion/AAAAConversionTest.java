package test.dns.conversion;

import static fixture.dns.wiredata.TestQueries.MOZILLA_ORG_AAAA;
import static fixture.dns.wiredata.TestQueries.makeTestQuery;
import static org.assertj.core.api.Assertions.assertThat;

import java.net.UnknownHostException;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import dk.mada.dns.filter.Deny;
import dk.mada.dns.filter.Block;
import dk.mada.dns.filter.Allow;
import dk.mada.dns.lookup.LookupEngine;
import dk.mada.dns.lookup.LookupResult;
import dk.mada.dns.lookup.Query;
import dk.mada.dns.resolver.DefaultResolver;
import dk.mada.dns.resolver.Resolver;
import dk.mada.dns.resolver.external.ExternalDnsGateway;
import dk.mada.dns.service.DevelopmentDebugging;
import dk.mada.dns.wire.model.DnsReply;
import dk.mada.dns.wire.model.DnsRequest;
import dk.mada.dns.wire.model.DnsRequests;
import fixture.resolver.CannedUdpResolver;

public class AAAAConversionTest {
	/**
	 * DNS requests of type AAAA (IPv6) for mozilla.org do not return an IP
	 * address, but a SOA response.
	 * Maybe used by browser to determine that a site does not support
	 * IPv6?
	 * 
	 * For now, the SOA/authority reply is *not* returned.
	 */
	@Test
	public void currentlyIgnoresSoaResponse() {
		DnsRequest request = DnsRequests.fromWireData(MOZILLA_ORG_AAAA);

		ExternalDnsGateway dnsGateway = new ExternalDnsGateway(new DevelopmentDebugging());
		Optional<DnsReply> reply = new DefaultResolver(dnsGateway).resolve("127.0.0.1", request);

		assertThat(reply)
			.get()
			.satisfies(r -> r.getAnswer().getRecords().isEmpty())
			.extracting(DnsReply::getAuthority)
				.isNull();
	}
	
	/** 
	 * Mozilla.org does not appear to be available on IPv6, so the answer section is empty.
	 */
	@Test
	public void canHandleRepliesWithEmptyAnswerSection() throws UnknownHostException {
		Query q = makeTestQuery(MOZILLA_ORG_AAAA);

		Resolver resolver = new CannedUdpResolver(MOZILLA_ORG_AAAA);
		Deny deny = h -> false;
		Allow allow = h -> false;
		Block block = h -> false;
		
		var sut = new LookupEngine(resolver, allow, deny, block);
		LookupResult result = sut.lookup(q);

		assertThat(result.getReply().getAnswer().getRecords())
			.isEmpty();
	}
}
