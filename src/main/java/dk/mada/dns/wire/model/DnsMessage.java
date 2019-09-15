package dk.mada.dns.wire.model;

import java.util.Objects;

//https://www.ietf.org/rfc/rfc1035.txt
	
/**
 * DNS message - containing both question and answers.
 */
class DnsMessage {
	private final DnsHeader header;
	private final DnsSection questionSection;
	private DnsSection answer;
	private DnsSection authority;
	private DnsSection additional;

	protected DnsMessage(DnsHeader header, DnsSection questionSection) {
		this.header = Objects.requireNonNull(header);
		this.questionSection = Objects.requireNonNull(questionSection);
	}
	
	public DnsHeader getHeader() {
		return header;
	}

	public DnsSection getQuestionSection() {
		return questionSection;
	}
	
	public DnsRecordQ getQuestion() {
		return questionSection
				.getRecords()
				.get(0)
				.asRecordQ()
				.orElseThrow(() -> new IllegalStateException("Message contains no question?!"));
	}
	
	public DnsSection getAnswer() {
		return answer;
	}
	public void setAnswer(DnsSection answer) {
		this.answer = answer;
	}
	public DnsSection getAuthority() {
		return authority;
	}
	public void setAuthority(DnsSection authority) {
		this.authority = authority;
	}
	public DnsSection getAdditional() {
		return additional;
	}
	public void setAdditional(DnsSection additional) {
		this.additional = additional;
	}
}