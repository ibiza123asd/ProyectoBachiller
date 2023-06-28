package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Agenda;
import modelo.Especialidad;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-06-28T00:16:52")
@StaticMetamodel(Medico.class)
public class Medico_ { 

    public static volatile SingularAttribute<Medico, String> nombreMedico;
    public static volatile SingularAttribute<Medico, String> apellidoMat;
    public static volatile SingularAttribute<Medico, Integer> idMedico;
    public static volatile ListAttribute<Medico, Agenda> agendaList;
    public static volatile SingularAttribute<Medico, String> telefono;
    public static volatile SingularAttribute<Medico, Especialidad> idEspecialidad;
    public static volatile SingularAttribute<Medico, String> apellidoPat;

}