package com.api.vacinacao.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
@Entity
@Table(name = "VACINACAO")
public class Vacinacao implements Serializable {
	
	private static final long serialVersionUID = -3468216930795597536L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	@PrimaryKeyJoinColumn
	private Long id;
	
	@NotNull
	@NotBlank(message="Nome da vacina é obrigatório.")
	@Column(name = "NOME_VACINA")
	@Size(min = 3, max = 40)
	private String nomeVacina;
	
	@NotNull(message="Favor fornecer data de vacinação.")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	@Column(name = "DATA_VACINACAO")
	private Date dataVacinacao;
	
	@Email
	@NotNull(message="O email de usuário é obrigatório.")
	@NotBlank(message = "O email de usuário é obrigatório.")
	@Column(name = "EMAIL_USUARIO")
	@Size(min = 8, max = 30)
	private String emailUsuario;
}
