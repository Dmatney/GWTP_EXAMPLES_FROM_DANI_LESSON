package Apple.King.server;

import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import Apple.King.client.GetFirst;
import Apple.King.client.GetFirstResult;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;

public class GetFirstActionHandler implements
		ActionHandler<GetFirst, GetFirstResult> {

	@Inject
	public GetFirstActionHandler() {
	}

	@Override
	public GetFirstResult execute(GetFirst action, ExecutionContext context)
			throws ActionException {String text = action.getText();
			text = text.toLowerCase();
			
			return new GetFirstResult(text);
	}

	@Override
	public void undo(GetFirst action, GetFirstResult result,
			ExecutionContext context) throws ActionException {
		
	}

	@Override
	public Class<GetFirst> getActionType() {
		return GetFirst.class;
	}
}
