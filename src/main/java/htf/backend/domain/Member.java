package htf.backend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
public class Member { 
	private @Id @GeneratedValue @Column(name="mem_key")Long memKey; 
	private @Column(name="mem_id") String memId;
	private @Column(name="mem_pw") String memPw;
	private @Column(name="mem_rank")String memRank;
	private String email;
	private String address;
	private String contact;
	private String kakaoToken;
	private String sid;
	private @ManyToOne @JoinColumn(name="ad_id") @OnDelete(action = OnDeleteAction.CASCADE) Admin adId;
} 
