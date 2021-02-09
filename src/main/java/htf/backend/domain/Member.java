package htf.backend.domain;

import java.sql.Time;
import java.sql.Timestamp;

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
	private @Id @GeneratedValue @Column(name="mem_key")Long memKey; 
	private @Column(name="mem_id") String memId;
	private @Column(name="mem_pw") String memPw;
	private @Column(name="mem_rank")String memRank;
//	private @Column Timestamp expireDate;
	private @ManyToOne Admin adId;
	
} 
