/**
 *    Copyright 2013, Big Switch Networks, Inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License"); you may
 *    not use this file except in compliance with the License. You may obtain
 *    a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *    WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *    License for the specific language governing permissions and limitations
 *    under the License.
 **/

package net.floodlightcontroller.loadbalancer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class LBMonitorSerializer extends JsonSerializer<LBMonitor>{
	
	@Override
	public void serialize(LBMonitor monitor, JsonGenerator jGen, SerializerProvider serializer)
			throws IOException, JsonProcessingException {
		jGen.writeStartObject();

		jGen.writeStringField("id", monitor.id);
		jGen.writeStringField("name", monitor.name);
		//jGen.writeStringField("address", String.valueOf(monitor.address));
		//jGen.writeStringField("port", Short.toString(monitor.port));
		jGen.writeStringField("type", Short.toString(monitor.type));
		jGen.writeStringField("poolId", monitor.poolId);
		//jGen.writeStringField("delay", Short.toString(monitor.delay));
		//jGen.writeStringField("attemptsBeforeDeactivation", Short.toString(monitor.attemptsBeforeDeactivation));
		jGen.writeEndObject();
		
	}
}
