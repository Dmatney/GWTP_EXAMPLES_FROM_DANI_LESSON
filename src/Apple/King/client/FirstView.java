package Apple.King.client;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class FirstView extends ViewImpl implements FirstPresenter.MyView {

	private final Widget widget;
	
	@UiField Label firstLabel;
	@UiField TextBox firstBox;
	@UiField Button firstButton;
	public interface Binder extends UiBinder<Widget, FirstView> {
	}

	@Inject
	public FirstView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}
	
	public Label getFirstLabel() {
		return firstLabel;
	}

	public TextBox getFirstBox() {
		return firstBox;
	}
	
	public Button getFirstButton() {
		return firstButton;
	}

	
}
