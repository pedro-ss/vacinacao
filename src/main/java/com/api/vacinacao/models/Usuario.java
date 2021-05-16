package com.api.vacinacao.models;

import java.io.Serializable;
import java.time.LocalDate;

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

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;
import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 7173404267719672340L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID", unique = true)
	@PrimaryKeyJoinColumn
	private Long id;
	
    @NotNull(message="Nome é obrigatório.")
    @NotBlank(message="Nome é obrigatório.")
	@Column(name = "NOME")
	@Size(min = 3, max = 100)
	private String nome;

	@Email
    @NotNull(message="Email é obrigatório.")
	@Column(name = "EMAIL", unique = true)
	@Size(min = 8, max = 40)
	private String email;
	
	@CPF
    @NotNull(message="Cpf é obrigatório.")
	@Column(name = "CPF", unique = true)
	private String cpf;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    @NotNull(message="Favor fornecer data de nascimento.")
	@Column(name = "NASCIMENTO")
	private LocalDate dataNascimento;
}
