package test.dns.config;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import dk.mada.dns.config.ConfigurationModel;
import dk.mada.dns.config.ConfigurationSerializer;

public class ConfigurationParsingTest {
	@Test
	public void shouldParseProrpertyLines() {
		var m = new ConfigurationModel();
		new ConfigurationSerializer().load(m, Stream.of(":unknown=foobar", ":blockedTtlSeconds = 38"));
		
		assertThat(m.getBlockedTtlSeconds()).isEqualTo(38);
	}

	@Test
	public void shouldParseHostLines() {
		var m = new ConfigurationModel();
		new ConfigurationSerializer().load(m, Stream.of("-facebook.dk: just because", "-facebook.ru", "+xkcd.com: good stuff", "+test.dk", "+long-winded.dk: because: it: is!"));
		
		assertThat(m.getDeniedHostNames())
			.containsOnly("facebook.dk", "facebook.ru");
		assertThat(m.getAllowedHostNames())
			.containsOnly("xkcd.com", "test.dk", "long-winded.dk");
		assertThat(m.getAllowedHosts())
			.anyMatch(d -> "because: it: is!".equals(d.getReason()));
	}

	@Test
	public void shouldParseDomainLines() {
		var m = new ConfigurationModel();
		new ConfigurationSerializer().load(m, Stream.of("-.facebook.dk: x", "-.facebook.ru", "+.xkcd.com: good stuff", "+.test.dk", "+.long-winded.dk: because: it: is!"));
		
		assertThat(m.getDeniedDomainNames())
			.containsOnly("facebook.dk", "facebook.ru");
		assertThat(m.getAllowedDomainNames())
			.containsOnly("xkcd.com", "test.dk", "long-winded.dk");
		assertThat(m.getDeniedDomains())
			.anyMatch(d -> "x".equals(d.getReason()));
	}
}
