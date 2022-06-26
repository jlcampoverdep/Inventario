package com.example.demo.entity;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity 
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1671417246199538663L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long id;
	
	@Column
	@NotBlank
	@Size(min=5,max=8,message="No se cumple las reglas del tamano")
	private String nombre;
		@Column
	@NotBlank
	private String email;
	@Column
	@NotBlank
	private String username;
	@Column
	@NotBlank
	private String password;
	
	@Column
	@NotBlank
	private String cedula;
	
	@Column
	private String fecha_nacimiento;
	
	@Column
	private String direccion;
	
	@Column
	private String estado_vacunacion;
	
	@Column
	private String tipo_vacuna;
	
	@Column
	private String fecha_vacuna;

	@Column
	private String numero_dosis;
	
	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstado_vacunacion() {
		return estado_vacunacion;
	}

	public void setEstado_vacunacion(String estado_vacunacion) {
		this.estado_vacunacion = estado_vacunacion;
	}

	public String getTipo_vacuna() {
		return tipo_vacuna;
	}

	public void setTipo_vacuna(String tipo_vacuna) {
		this.tipo_vacuna = tipo_vacuna;
	}

	public String getFecha_vacuna() {
		return fecha_vacuna;
	}

	public void setFecha_vacuna(String fecha_vacuna) {
		this.fecha_vacuna = fecha_vacuna;
	}

	public String getNumero_dosis() {
		return numero_dosis;
	}

	public void setNumero_dosis(String numero_dosis) {
		this.numero_dosis = numero_dosis;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	@Transient
	private String confirmPassword;
	
	@Size(min=1)
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles",
			joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set<Role> roles;

	public User() {
		super();
	}

	public User(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nombre=" + nombre +  ", email=" + email
				+ ", username=" + username + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", roles=" + roles + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cedula, confirmPassword, direccion, email, estado_vacunacion, fecha_nacimiento,
				fecha_vacuna, id, nombre, numero_dosis, password, roles, tipo_vacuna, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(cedula, other.cedula) && Objects.equals(confirmPassword, other.confirmPassword)
				&& Objects.equals(direccion, other.direccion) && Objects.equals(email, other.email)
				&& Objects.equals(estado_vacunacion, other.estado_vacunacion)
				&& Objects.equals(fecha_nacimiento, other.fecha_nacimiento)
				&& Objects.equals(fecha_vacuna, other.fecha_vacuna) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(numero_dosis, other.numero_dosis)
				&& Objects.equals(password, other.password) && Objects.equals(roles, other.roles)
				&& Objects.equals(tipo_vacuna, other.tipo_vacuna) && Objects.equals(username, other.username);
	}

}