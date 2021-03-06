package dk.mada.dns.rest.dto;

/**
 * DTO for a domain denied or allowed.
 */
public class DomainDto {
	public String domain;
	public String reason;
	
	public static DomainDto from(String domain, String reason) {
		var dto = new DomainDto();
		dto.domain = domain;
		dto.reason = reason;
		return dto;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domain == null) ? 0 : domain.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DomainDto other = (DomainDto) obj;
		if (domain == null) {
			if (other.domain != null)
				return false;
		} else if (!domain.equals(other.domain))
			return false;
		return true;
	}
}
