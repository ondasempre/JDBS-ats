public interface DAOConstants {
	String JDBC_DRIVER="oracle.jdbc.driver.OracleDriver";
	String JDBC_URL="jdbc:oracle:thin:@10.0.1.18:1521:orcl"; //sulla macchina non c'è oracle posso connetermi con qualsiasi db ma più lento altrimenti :oci ci deve essere per forza oracle
	String USERNAME= "salvatore";
	String PASSWORD="pass";
	String SELECT_UTENTE="select * from UTENTE";	
	String SQL="select * from utente where lower(nome) like ? or lower(cognome) like ?";
	String PLSQL="{call GESTISCI_IMP(?,?)}"; //chiamate alle procedure sempre nelle graffe dall'esterno tramite call nomeP poiche questa procedura ha 2 variabili in input (livello e modifica come parametri variabile);

}
