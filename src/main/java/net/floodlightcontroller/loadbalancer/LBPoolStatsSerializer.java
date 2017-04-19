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

		jGen.writeStringField("Bytes In", String.valueOf(poolStats.bytesIn));
		jGen.writeStringField("Bytes Out", String.valueOf(poolStats.bytesOut));
		jGen.writeStringField("Active Connections", String.valueOf(poolStats.activeConnections));
		jGen.writeStringField("Total Connections", String.valueOf(poolStats.totalConnections));

		jGen.writeEndObject();

	}
}
