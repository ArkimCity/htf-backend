package htf.backend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Machine {
	private @Id  @Column(name="mch_id") String mchId;
	private @ManyToOne @JoinColumn(name="mem_id") Member memId;
	private String description;
	private String type;
	private @ManyToOne Vendor vendorId;
}
