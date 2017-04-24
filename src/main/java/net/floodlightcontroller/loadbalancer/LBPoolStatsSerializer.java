package net.floodlightcontroller.loadbalancer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class LBPoolStatsSerializer extends JsonSerializer<LBPoolStats>{

	@Override
	public void serialize(LBPoolStats poolStats, JsonGenerator jGen,
			SerializerProvider serializer) throws IOException,
	JsonProcessingException {
		jGen.writeStartObject();

		jGen.writeStringField("Total Bytes", String.valueOf(poolStats.totalBytes));
		jGen.writeStringField("Total Packets", String.valueOf(poolStats.packets));
		jGen.writeStringField("Active Connections", String.valueOf(poolStats.activeConnections));

		jGen.writeEndObject();

	}
}
