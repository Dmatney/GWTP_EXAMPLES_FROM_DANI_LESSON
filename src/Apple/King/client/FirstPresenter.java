package Apple.King.client;

import Apple.King.client.place.NameTokens;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ManualRevealCallback;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

public class FirstPresenter extends
		Presenter<FirstPresenter.MyView, FirstPresenter.MyProxy> {

	public static final Object SLOT_Rate = new Object();
	
	public interface MyView extends View {
		public Label getFirstLabel();

		public TextBox getFirstBox();

		public Button getFirstButton();
	}
	
	@Inject	RatePagePresenter ratePagePresenter;

	@ProxyStandard
	@NameToken(NameTokens.first)
	public interface MyProxy extends ProxyPlace<FirstPresenter> {
	}

	@Inject
	public FirstPresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy) {
		super(eventBus, view, proxy);
	}

	@Override
	protected void revealInParent() {
		RevealContentEvent.fire(this, HeaderPresenter.SLOT_content, this);
	}
	
	@Override
	public boolean useManualReveal() {
		return true;
	}
	@Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);
		
		GetData action = new GetData();
		dispatchAsync.execute(action, getDataCallback);
	}
	private AsyncCallback<GetDataResult> getDataCallback = ManualRevealCallback.create(this, new AsyncCallback<GetDataResult>(){
		@Override
		public void onSuccess(GetDataResult result) {
			getView().getFirstBox().setText(result.getData());
			
		};
		@Override
		public void onFailure(Throwable caught) {};
	});
	@Override
	protected void onBind() {
		super.onBind();
	}
	@Inject PlaceManager placeManager;
	@Inject DispatchAsync dispatchAsync;
	
	@Override
	protected void onReset() {
		super.onReset();
		
		setInSlot(SLOT_Rate, ratePagePresenter);
		
		//getView().getFirstBox().setText("First Text");
		
		getView().getFirstButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
			GetFirst action = new GetFirst(getView().getFirstBox().getText());
			dispatchAsync.execute(action,  getFirstCallback);
			}
		});
	}
	private AsyncCallback<GetFirstResult> getFirstCallback = new AsyncCallback<GetFirstResult>() {
		@Override
		public void onSuccess(GetFirstResult result) {
			PlaceRequest request = new PlaceRequest (NameTokens.getSecond()).with("name",result.getText());
			placeManager.revealPlace(request);
		}
		@Override
		public void onFailure(Throwable caught) {
			
		}
	};
}

