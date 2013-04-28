package Apple.King.client;

import Apple.King.client.place.NameTokens;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.gwtplatform.common.client.IndirectProvider;
import com.gwtplatform.common.client.StandardProvider;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

public class SecondPresenter extends
		Presenter<SecondPresenter.MyView, SecondPresenter.MyProxy> {
	public static final Object SLOT_list =new Object();
	public interface MyView extends View {
		public Label getSecondLabel();
	}

	@ProxyCodeSplit
	@NameToken(NameTokens.second)
	public interface MyProxy extends ProxyPlace<SecondPresenter> {
	}

	private IndirectProvider<RatePagePresenter> ratePageFactory;


@Inject
	public SecondPresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy, Provider<RatePagePresenter> ratePageFactory) {
		super(eventBus, view, proxy);
		
		this.ratePageFactory = new StandardProvider<RatePagePresenter>(ratePageFactory);
	}

	@Override
	protected void revealInParent() {
		RevealContentEvent.fire(this, HeaderPresenter.SLOT_content, this);

	}
	
	private String name ="";
	
	@Override
	public void prepareFromRequest(PlaceRequest request) {
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
		
		setInSlot(SLOT_list, null);
		for (int i=0; i<3; i++){
			ratePageFactory.get(new AsyncCallback<RatePagePresenter>() {
				
				@Override
				public void onSuccess(RatePagePresenter result) {
					addToSlot(SLOT_list, result);
				}
				
				@Override
				public void onFailure(Throwable caught) {
					
				}
			});
		}

	}
}
