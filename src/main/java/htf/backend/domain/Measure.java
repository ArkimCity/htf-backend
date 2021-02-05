package htf.backend.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Measure {
	private @Id @GeneratedValue Long measure_id;
	private @ManyToOne Machine mch_id;
	private String mchcd;
	private String param;
	private String value;
	private String created;
	private String modified;  
}
