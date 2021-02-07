package htf.backend.domain;

import javax.persistence.Column;
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
public class Member { 
	private @Id @GeneratedValue Long mem_key; 
	private @Column(name="mem_id") String memId;
	private @Column(name="mem_pw") String memPw;
	private String mem_rank;
	private @ManyToOne Admin ad_id;
	
} 
