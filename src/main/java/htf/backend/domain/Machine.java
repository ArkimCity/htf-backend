package htf.backend.domain;

import javax.persistence.Entity;
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
public class Machine {
	private @Id String mch_id;
	private @ManyToOne @JoinColumn(name="mem_id") Member memId;
	private String description;
}
