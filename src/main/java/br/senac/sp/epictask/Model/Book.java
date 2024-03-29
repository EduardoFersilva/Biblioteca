package br.senac.sp.epictask.Model;

//import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank
    String title;

    @NotBlank
    String autor;

    @NotNull
    Long launch;

    @NotBlank
    String company;

    @NotBlank
    String language;
    
    @Size(min = 10, message =  "Digite uma descrição com pelo menos 10 caracteres")
    String description;

}
