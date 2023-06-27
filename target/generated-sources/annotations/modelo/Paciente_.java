package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-06-26T20:01:42")
@StaticMetamodel(Paciente.class)
public class Paciente_ { 

    public static volatile SingularAttribute<Paciente, Integer> idPaciente;
    public static volatile SingularAttribute<Paciente, String> apellidoPaterno;
    public static volatile SingularAttribute<Paciente, Boolean> seguroSIS;
    public static volatile SingularAttribute<Paciente, String> correo;
    public static volatile SingularAttribute<Paciente, String> contrasena;
    public static volatile SingularAttribute<Paciente, String> nombre;
    public static volatile SingularAttribute<Paciente, Integer> edad;
    public static volatile SingularAttribute<Paciente, String> dni;
    public static volatile SingularAttribute<Paciente, String> apellidoMaterno;

}