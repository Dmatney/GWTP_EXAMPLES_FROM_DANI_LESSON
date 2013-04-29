package Apple.King.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PopupViewImpl;

public class WhyNotView extends PopupViewImpl implements WhyNotPresenter.MyView {

	private final Widget widget;
	
	@UiField Button okButton;
	
	public interface Binder extends UiBinder<Widget, WhyNotView> {
	}

	@Inject
	public WhyNotView(final EventBus eventBus, final Binder binder) {
		super(eventBus);
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}
	public Button getOkButton() {
		return okButton;
	}
}
