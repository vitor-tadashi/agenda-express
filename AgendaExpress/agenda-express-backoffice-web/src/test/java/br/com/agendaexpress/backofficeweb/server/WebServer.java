package br.com.agendaexpress.backofficeweb.server;

import java.io.InputStream;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.xml.XmlConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebServer extends Thread {
	private static final Logger LOG = LoggerFactory.getLogger(WebServer.class);

	@Override
	public void start() {
		try {
			LOG.info("Starting  Jetty Agenda-Express Backoffice Web Server...");
			InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("jetty.xml");
			XmlConfiguration configuration = new XmlConfiguration(in);
			Server server = (Server) configuration.configure();

			server.start();
			LOG.info("Jetty Agenda-Express Backoffice Web Server on the fly...");

			server.join();
			LOG.info("Jetty Web Server stopped!");

		} catch (final Exception e) {
			e.printStackTrace();
			System.exit(100);
		}
	}

	public static void main(final String[] args) {
		final WebServer webServer = new WebServer();
		webServer.start();
	}
}
