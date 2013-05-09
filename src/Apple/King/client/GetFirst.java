package Apple.King.client;

import com.gwtplatform.dispatch.shared.ActionImpl;

public class GetFirst extends ActionImpl<GetFirstResult> {

	private String text;
	
	// isSecured prevents this "SEVERE: Cookie provided by RPC doesn't match request cookie, aborting action, possible XSRF attack. (Maybe you forgot to set the security cookie?) While executing action: Apple.King.client.GetFirst"
	// You can use the security cookie instead. 
	// You put this bindConstant().annotatedWith(SecurityCookie.class).to("MYCOOKIE"); into ClientModule 
	//  and you put bindConstant().annotatedWith(SecurityCookie.class).to("MYCOOKIE"); 
	//         AND   filter("*.html").through(RandomSecurityCookieFilter.class); into DispatchServletModule 
	/*
	@Override
	public boolean isSecured() {
		return false;
	}
	*/
	
	@SuppressWarnings("unused")
	private GetFirst() {
		// For serialization only
	}

	public GetFirst(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
