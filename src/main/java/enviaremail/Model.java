package enviaremail;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {
	
	private StringProperty server = new SimpleStringProperty();
	private StringProperty port = new SimpleStringProperty();
	private BooleanProperty useSSL = new SimpleBooleanProperty();
	private StringProperty from = new SimpleStringProperty();
	private StringProperty password = new SimpleStringProperty();
	private StringProperty to = new SimpleStringProperty();
	private StringProperty subject = new SimpleStringProperty();
	private StringProperty message = new SimpleStringProperty();
	
	public final StringProperty serverProperty() {
		return this.server;
	}
	
	public final String getServer() {
		return this.serverProperty().get();
	}
	
	public final void setServer(final String server) {
		this.serverProperty().set(server);
	}
	
	public final StringProperty portProperty() {
		return this.port;
	}
	
	public final String getPort() {
		return this.portProperty().get();
	}
	
	public final void setPort(final String port) {
		this.portProperty().set(port);
	}
	
	public final BooleanProperty useSSLProperty() {
		return this.useSSL;
	}
	
	public final boolean useSSL() {
		return this.useSSLProperty().get();
	}
	
	public final void setUseSSL(final boolean useSSL) {
		this.useSSLProperty().set(useSSL);
	}
	
	public final StringProperty fromProperty() {
		return this.from;
	}
	
	public final String getFrom() {
		return this.fromProperty().get();
	}
	
	public final void setFrom(final String from) {
		this.fromProperty().set(from);
	}
	
	public final StringProperty passwordProperty() {
		return this.password;
	}
	
	public final String getPassword() {
		return this.passwordProperty().get();
	}
	
	public final void setPassword(final String password) {
		this.passwordProperty().set(password);
	}
	
	public final StringProperty toProperty() {
		return this.to;
	}
	
	public final String getTo() {
		return this.toProperty().get();
	}
	
	public final void setTo(final String to) {
		this.toProperty().set(to);
	}
	
	public final StringProperty subjectProperty() {
		return this.subject;
	}
	
	public final String getSubject() {
		return this.subjectProperty().get();
	}
	
	public final void setSubject(final String subject) {
		this.subjectProperty().set(subject);
	}
	
	public final StringProperty messageProperty() {
		return this.message;
	}
	
	public final String getMessage() {
		return this.messageProperty().get();
	}
	
	public final void setMessage(final String message) {
		this.messageProperty().set(message);
	}
	
	
	
}
