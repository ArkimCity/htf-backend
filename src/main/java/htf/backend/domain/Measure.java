package htf.backend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Measure {
	private @Id @GeneratedValue @Column(name="measure_id") Long measureId;
	private @ManyToOne @JoinColumn(name="mch_id") Machine mchId;
	private String mchcd;
	private String param;
	private String value;
	private String created;
	private String modified;  
}
