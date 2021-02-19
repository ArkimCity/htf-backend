package htf.backend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
	private @ManyToOne @JoinColumn(name="mem_id") @OnDelete(action = OnDeleteAction.CASCADE) Member memId;
	private String description;
	private String type;
	private @ManyToOne @OnDelete(action = OnDeleteAction.CASCADE) Vendor vendorId;
}
