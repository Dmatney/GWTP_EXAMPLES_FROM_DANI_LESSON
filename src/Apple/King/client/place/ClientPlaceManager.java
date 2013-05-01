package Apple.King.client.place;

import com.gwtplatform.mvp.client.proxy.PlaceManagerImpl;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import Apple.King.client.place.DefaultPlace;
import com.google.inject.Inject;
import com.google.gwt.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.TokenFormatter;

public class ClientPlaceManager extends PlaceManagerImpl {

	private final PlaceRequest defaultPlaceRequest;

	@Inject
	public ClientPlaceManager(final EventBus eventBus,
			final TokenFormatter tokenFormatter,
			@DefaultPlace final String defaultPlaceNameToken) {
		super(eventBus, tokenFormatter);
		this.defaultPlaceRequest = new PlaceRequest(defaultPlaceNameToken);
	}

	@Override
	public void revealDefaultPlace() {
		revealPlace(defaultPlaceRequest, false);
	}
		@Override
		public void revealErrorPlace(String invalidHistoryToken) {
			PlaceRequest request = new PlaceRequest(NameTokens.error);
			revealPlace(request, false);
			//adding the False prevents the page from changing the URL
		}
	@Override
	public void revealUnauthorizedPlace(String unauthorizedHistoryToken) {
		//Can be used to redirect the user back to the page they were trying to access rather than the default page after signing in
		//PlaceRequest current = getCurrentPlaceRequest();
		
		PlaceRequest request = new PlaceRequest(NameTokens.login);
		revealPlace(request);
	}
}
