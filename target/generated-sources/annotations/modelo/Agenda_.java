package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Medico;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-06-30T13:54:30")
=======
@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2023-06-30T17:35:59")
>>>>>>> a45132942850a4bb3511f7af599becde36babeb5
@StaticMetamodel(Agenda.class)
public class Agenda_ { 

    public static volatile SingularAttribute<Agenda, Date> fechaHora;
    public static volatile SingularAttribute<Agenda, Integer> idAgenda;
    public static volatile SingularAttribute<Agenda, Medico> idMedico;
    public static volatile SingularAttribute<Agenda, String> turno;

}