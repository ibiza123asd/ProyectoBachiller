package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Medico;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-06-26T20:01:42")
@StaticMetamodel(Agenda.class)
public class Agenda_ { 

    public static volatile SingularAttribute<Agenda, Date> fechaHora;
    public static volatile SingularAttribute<Agenda, Integer> idAgenda;
    public static volatile SingularAttribute<Agenda, Medico> idMedico;
    public static volatile SingularAttribute<Agenda, String> turno;

}