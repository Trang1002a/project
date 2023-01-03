package com.example.project.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_showtimes")
public class Showtimes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "movies_id")
	private String movies_id;
	@Column(name = "branch_id")
	private String branch_id;
	@Column(name = "room_id")
	private String room_id;
	@Column(name = "hours_id")
	private String hours_id;
	@Column(name = "movie_day")
	private String movie_day;
	@Column(name = "created_at")
	private Date created_at;
	@Column(name = "status")
	private boolean status;
}
