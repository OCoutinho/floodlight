package net.floodlightcontroller.loadbalancer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using=LBPoolStatsSerializer.class)
public class LBPoolStats {

	protected long bytesIn;
	protected long bytesOut;
	protected int activeConnections;
	protected int totalConnections;
	
	public LBPoolStats(){
		this.bytesIn = 0;
		this.bytesOut = 0;
		this.activeConnections = 0;
		this.totalConnections = 0;
	}

	public LBPoolStats getStats(){
		return this;
	}
	
	public long getBytesIn() {
		return bytesIn;
	}
	
	public long getBytesOut() {
		return bytesOut;
	}
	
	public int getActiveConnections() {
		return activeConnections;
	}
	
	public int getTotalConnections() {
		return totalConnections;
	}
	
	public void setBytesIn(int bytesIn) {
		this.bytesIn = bytesIn;
	}

	public void setBytesOut(int bytesOut) {
		this.bytesOut = bytesOut;
	}

	public void setActiveConnections(int activeConnections) {
		this.activeConnections = activeConnections;
	}

	public void setTotalConnections(int totalConnections) {
		this.totalConnections = totalConnections;
	}
}
