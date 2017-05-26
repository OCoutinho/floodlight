package net.floodlightcontroller.loadbalancer;

import java.util.Collections;

import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

public class ConfigResource extends ServerResource{
	
	@Post
	@Put
	public Object config() {
		ILoadBalancerService lbs = (ILoadBalancerService) getContext().getAttributes().get(ILoadBalancerService.class.getCanonicalName());

		if (getReference().getPath().contains(LoadBalancerWebRoutable.ENABLE_STR)) {
			lbs.healthMonitoring(true);
			return Collections.singletonMap("health monitors", "enabled");
		}
		
		if (getReference().getPath().contains(LoadBalancerWebRoutable.DISABLE_STR)) {
			lbs.healthMonitoring(false);
			return Collections.singletonMap("health monitors", "disabled");
		}
	
		return Collections.singletonMap("ERROR", "Unimplemented configuration option");
	}
}
