package Apple.King.client;

import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.NameToken;
import Apple.King.client.place.NameTokens;

import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.google.inject.Inject;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Label;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;

public class SecondPresenter extends
		Presenter<SecondPresenter.MyView, SecondPresenter.MyProxy> {
	
	public interface MyView extends View {
		public Label getSecondLabel();
	}

	@ProxyCodeSplit
	@NameToken(NameTokens.second)
	public interface MyProxy extends ProxyPlace<SecondPresenter> {
	}

	@Inject
	public SecondPresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy) {
		super(eventBus, view, proxy);
	}

	@Override
	protected void revealInParent() {
		RevealRootContentEvent.fire(this, this);
	}
	
	private String name ="";
	
	@Override
	public void prepareFromRequest(PlaceRequest request) {
		// TODO Auto-generated method stub
		super.prepareFromRequest(request);
		
		name = request.getParameter("name", "Default Value");
	}
	@Override
	protected void onBind() {
		super.onBind();
	}

	@Override
	protected void onReset() {
		super.onReset();
		
		getView().getSecondLabel().setText(name);

	}
}
