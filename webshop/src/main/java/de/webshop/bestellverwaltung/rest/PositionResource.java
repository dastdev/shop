package de.webshop.bestellverwaltung.rest;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;
import static javax.ws.rs.core.MediaType.TEXT_XML;
import static de.webshop.util.Constants.SELF_LINK;
import java.net.URI;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import de.webshop.artikelverwaltung.domain.Artikel;
import de.webshop.artikelverwaltung.rest.ArtikelResource;
import de.webshop.bestellverwaltung.domain.Position;
import de.webshop.util.Mock;
import de.webshop.util.rest.UriHelper;

@Path("/position")
@Produces({ APPLICATION_JSON, APPLICATION_XML + ";qs=0.75", TEXT_XML + ";qs=0.5" })
@Consumes
public class PositionResource {
	
	@Context
	private UriInfo			uriInfo;
	
	@Inject
	private UriHelper		uriHelper;
	
	@Inject
	private ArtikelResource	artikelResource;
	
	@GET
	@Path("{id:[1-9][0-9]*}")
	public Response findPositionById(@PathParam("id") long id) {
		
		final Position position = Mock.findPositionById(id);
		
		if (position == null) {
			throw new NotFoundException(
										String.format("Keine Position mit der ID %li gefunden.", id));
		}
		setStructuralLinks(position, uriInfo);
		
		// Link-Header setzen
		final Response response = Response.ok(position)
											.links(getTransitionalLinks(position, uriInfo)).build();
		
		return response;
	}
	
	public void setStructuralLinks(Position position, UriInfo uriInfo) {
		// URI fuer Artikel setzen
		final Artikel artikel = position.getArtikel();
		if (artikel != null) {
			// FIXME: ArtikelResource.getUriArtikel
			final URI artikelUri = null; // artikelResource.getUriArtikel(position.getArtikel(),
											// uriInfo);
			position.setArtikelUri(artikelUri);
		}
	}
	
	private Link[] getTransitionalLinks(Position position, UriInfo uriInfo) {
		final Link self = Link.fromUri(getUriPosition(position, uriInfo)).rel(SELF_LINK).build();
		return new Link[] { self };
	}
	
	public URI getUriPositionen(Position position, UriInfo uriInfo) {
		return uriHelper.getUri(BestellungResource.class, "findPositionenById", position.getId(),
								uriInfo);
	}
	
	public URI getUriPosition(Position position, UriInfo uriInfo) {
		return uriHelper.getUri(PositionResource.class, "findPositionById", position.getId(),
								uriInfo);
	}
	
}
