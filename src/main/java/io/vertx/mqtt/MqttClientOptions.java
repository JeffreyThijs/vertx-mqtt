/*
 * Copyright 2016 Red Hat Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.vertx.mqtt;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.impl.Arguments;
import io.vertx.core.json.JsonObject;
import io.vertx.core.net.JksOptions;
import io.vertx.core.net.KeyCertOptions;
import io.vertx.core.net.NetClientOptions;
import io.vertx.core.net.PemKeyCertOptions;
import io.vertx.core.net.PemTrustOptions;
import io.vertx.core.net.PfxOptions;
import io.vertx.core.net.TrustOptions;

/**
 * Represents options used by the MQTT client.
 */
@DataObject(generateConverter = true)
public class MqttClientOptions extends NetClientOptions {

  public static final int DEFAULT_PORT = 1883;
  public static final int DEFAULT_TSL_PORT = 8883;
  public static final String DEFAULT_HOST = "localhost";
  public static final int DEFAULT_WILL_QOS = 0;
  public static final int DEFAULT_KEEP_ALIVE_TIME_SECONDS = 30;
  public static final int DEFAULT_MAX_INFLIGHT_QUEUE = 10;
  public static final boolean DEFAULT_CLEAN_SESSION = true;
  public static final boolean DEFAULT_WILL_FLAG = false;
  public static final boolean DEFAULT_WILL_RETAIN = false;
  public static final int DEFAULT_MAX_MESSAGE_SIZE = -1;
  public static final int DEFAULT_ACK_TIMEOUT = -1;

  private String clientId;
  private String username;
  private String password;
  private String willTopic;
  private String willMessage;
  private boolean cleanSession = DEFAULT_CLEAN_SESSION;
  private boolean willFlag = DEFAULT_WILL_FLAG;
  private int willQoS = DEFAULT_WILL_QOS;
  private boolean willRetain = DEFAULT_WILL_RETAIN;
  private int keepAliveTimeSeconds = DEFAULT_KEEP_ALIVE_TIME_SECONDS;
  private boolean isAutoKeepAlive = true;
  private boolean isAutoGeneratedClientId = true;
  private int maxInflightQueue = DEFAULT_MAX_INFLIGHT_QUEUE;
  private int maxMessageSize = DEFAULT_MAX_MESSAGE_SIZE;
  private int ackTimeout = DEFAULT_ACK_TIMEOUT;

  /**
   * Default constructor
   */
  public MqttClientOptions() {
    super();
  }

  /**
   * Create an instance of MqttClientOptions from JSON
   *
   * @param json the JSON
   */
  public MqttClientOptions(JsonObject json) {
    super(json);
    MqttClientOptionsConverter.fromJson(json, this);
  }

  /**
   * Copy constructor
   *
   * @param other the options to copy
   */
  public MqttClientOptions(MqttClientOptions other) {
    super(other);
    this.clientId = other.clientId;
    this.username = other.username;
    this.password = other.password;
    this.willTopic = other.willTopic;
    this.willMessage = other.willMessage;
    this.cleanSession = other.cleanSession;
    this.willFlag = other.willFlag;
    this.willQoS = other.willQoS;
    this.willRetain = other.willRetain;
    this.keepAliveTimeSeconds = other.keepAliveTimeSeconds;
    this.isAutoKeepAlive = other.isAutoKeepAlive;
    this.isAutoGeneratedClientId = other.isAutoGeneratedClientId;
    this.maxInflightQueue = other.maxInflightQueue;
    this.maxMessageSize = other.maxMessageSize;
    this.ackTimeout = other.ackTimeout;
  }

  /**
   * @return if username is provided
   */
  public boolean hasUsername() {
    return username != null;
  }

  /**
   * @return if password is provided
   */
  public boolean hasPassword() {
    return password != null;
  }

  /**
   * @return if client wants to start with a clean session
   */
  public boolean isCleanSession() {
    return cleanSession;
  }

  /**
   * @return if will information are provided on connection
   */
  public boolean isWillFlag() {
    return willFlag;
  }

  /**
   * @return if the will messages must be retained
   */
  public boolean isWillRetain() {
    return willRetain;
  }

  /**
   * @return the QoS level for the will message
   */
  public int getWillQoS() {
    return willQoS;
  }

  /**
   * @return the keep alive timeout (in seconds)
   */
  public int getKeepAliveTimeSeconds() {
    return keepAliveTimeSeconds;
  }

  /**
   * @return provided username
   */
  public String getUsername() {
    return username;
  }

  /**
   * @return provided password
   */
  public String getPassword() {
    return password;
  }

  /**
   * @return client identifier
   */
  public String getClientId() {
    return clientId;
  }

  /**
   * @return topic on which the will message will be published
   */
  public String getWillTopic() {
    return willTopic;
  }

  /**
   * @return will message content
   */
  public String getWillMessage() {
    return willMessage;
  }

  /**
   * Set the client identifier
   *
   * @param clientId client identifier
   * @return current options instance
   */
  public MqttClientOptions setClientId(String clientId) {
    this.clientId = clientId;
    return this;
  }

  /**
   * Set the username
   *
   * @param username  username
   * @return current options instance
   */
  public MqttClientOptions setUsername(String username) {
    this.username = username;
    return this;
  }

  /**
   * Set the password
   *
   * @param password  password
   * @return current options instance
   */
  public MqttClientOptions setPassword(String password) {
    this.password = password;
    return this;
  }

  /**
   * Set the topic on which the will message will be published
   *
   * @param willTopic topic on which the will message will be published
   * @return current options instance
   */
  public MqttClientOptions setWillTopic(String willTopic) {
    this.willTopic = willTopic;
    return this;
  }

  /**
   * Set the content of the will message
   *
   * @param willMessage content of the will message
   * @return current options instance
   */
  public MqttClientOptions setWillMessage(String willMessage) {
    this.willMessage = willMessage;
    return this;
  }

  /**
   * Set to start with a clean session (or not)
   *
   * @param cleanSession if clean session should be activated
   * @return current options instance
   */
  public MqttClientOptions setCleanSession(boolean cleanSession) {
    this.cleanSession = cleanSession;
    return this;
  }

  /**
   * Set if will information are provided on connection
   *
   * @param willFlag if will information are provided on connection
   * @return current options instance
   */
  public MqttClientOptions setWillFlag(boolean willFlag) {
    this.willFlag = willFlag;
    return this;
  }

  /**
   * Set the QoS level for the will message
   *
   * @param willQoS QoS level for the will message
   * @return current options instance
   */
  public MqttClientOptions setWillQoS(int willQoS) {
    this.willQoS = willQoS;
    return this;
  }

  /**
   * Set if the will message must be retained
   *
   * @param willRetain if thw will message must be retained
   * @return current options instance
   */
  public MqttClientOptions setWillRetain(boolean willRetain) {
    this.willRetain = willRetain;
    return this;
  }

  /**
   * Set the keep alive timeout in seconds
   *
   * @param keepAliveTimeSeconds keep alive timeout in seconds
   * @return current options instance
   */
  public MqttClientOptions setKeepAliveTimeSeconds(int keepAliveTimeSeconds) {
    this.keepAliveTimeSeconds = keepAliveTimeSeconds;
    return this;
  }

  /**
   * Gets the time in seconds after which the client stops waiting for a PUBACK, PUBREC
   * or PUBCOMP packet from the server in response to a packet it has sent.
   * <p>
   * The default value of this property is 10s.
   *
   * @return timeout in seconds
   */
  public int getAckTimeout() {
    return this.ackTimeout;
  }

  /**
   * Sets the time in seconds after which the client will stop waiting for a PUBACK, PUBREC
   * or PUBCOMP packet from the server in response to a packet it has sent.
   * <p>
   * The default value of this property is -1 which indicates that the client should wait
   * an unlimited time for the server's acknowledgement.
   *
   * @param ackTimeoutSeconds timeout in seconds
   * @return current options instance
   * @throws IllegalArgumentException if the timeout is 0 or &lt; -1.
   */
  public MqttClientOptions setAckTimeout(int ackTimeoutSeconds) {
    if (ackTimeoutSeconds == 0 || ackTimeoutSeconds < -1) {
      throw new IllegalArgumentException("timeout must be > 0 or equal to -1");
    }
    this.ackTimeout = ackTimeoutSeconds;
    return this;
  }

  /**
   * @return max count of unacknowledged messages
   */
  public int getMaxInflightQueue() {
    return maxInflightQueue;
  }

  /**
   * Set max count of unacknowledged messages
   * @param maxInflightQueue max count of unacknowledged messages
   * @return current options instance
   */
  public MqttClientOptions setMaxInflightQueue(int maxInflightQueue) {
    this.maxInflightQueue = maxInflightQueue;
    return this;
  }

  /**
   * Set if the MQTT client must handle PINGREQ automatically
   * (default is true)
   *
   * @param isAutoKeepAlive ping request handled automatically
   * @return  current options instance
   */
  public MqttClientOptions setAutoKeepAlive(boolean isAutoKeepAlive) {
    this.isAutoKeepAlive = isAutoKeepAlive;
    return this;
  }

  /**
   * Set if the MQTT client must generate clientId automatically
   * (default is true)
   *
   * @param isAutoGeneratedClientId clientId generated automatically
   * @return  current options instance
   */
  public MqttClientOptions setAutoGeneratedClientId(boolean isAutoGeneratedClientId) {
    this.isAutoGeneratedClientId = isAutoGeneratedClientId;
    return this;
  }

  /**
   * @return if the PINGREQ is handled automatically
   */
  public boolean isAutoKeepAlive() {
    return this.isAutoKeepAlive;
  }

  /**
   * @return if clientId generated automatically
   */
  public boolean isAutoGeneratedClientId() {
    return isAutoGeneratedClientId;
  }

  /**
   * @return max MQTT message size
   */
  public int getMaxMessageSize() {
    return maxMessageSize;
  }

  @Override
  public MqttClientOptions setReceiveBufferSize(int receiveBufferSize) {
    if ((this.maxMessageSize > 0) && (receiveBufferSize > 0)) {
      Arguments.require(receiveBufferSize >= this.maxMessageSize,
        "Receiver buffer size can't be lower than max message size");
    }
    super.setReceiveBufferSize(receiveBufferSize);
    return this;
  }

  /**
   * Set max MQTT message size
   *
   * @param maxMessageSize  max MQTT message size
   * @return  MQTT client options instance
   */
  public MqttClientOptions setMaxMessageSize(int maxMessageSize) {
    Arguments.require(maxMessageSize > 0 || maxMessageSize == DEFAULT_MAX_MESSAGE_SIZE, "maxMessageSize must be > 0");
    if ((maxMessageSize > 0) && (this.getReceiveBufferSize() > 0)) {
      Arguments.require(this.getReceiveBufferSize() >= maxMessageSize,
        "Receiver buffer size can't be lower than max message size");
    }
    this.maxMessageSize = maxMessageSize;
    return this;
  }

  /**
   * Do the same thing as {@link MqttClientOptions#setKeepAliveTimeSeconds(int)}. Use it instead.
   */
  @Deprecated
  @Override
  public MqttClientOptions setIdleTimeout(int idleTimeout) {
    return setKeepAliveTimeSeconds(idleTimeout);
  }

  @Override
  public MqttClientOptions setSsl(boolean ssl) {
    super.setSsl(ssl);
    return this;
  }

  @Override
  public MqttClientOptions setTrustStoreOptions(JksOptions options) {
    super.setTrustStoreOptions(options);
    return this;
  }

  @Override
  public MqttClientOptions setTrustAll(boolean trustAll) {
    super.setTrustAll(trustAll);
    return this;
  }

  @Override
  public MqttClientOptions setKeyCertOptions(KeyCertOptions options) {
     super.setKeyCertOptions(options);
     return this;
  }

  @Override
  public MqttClientOptions setKeyStoreOptions(JksOptions options) {
     super.setKeyStoreOptions(options);
     return this;
  }

  @Override
  public MqttClientOptions setPfxKeyCertOptions(PfxOptions options) {
     super.setPfxKeyCertOptions(options);
     return this;
  }

  @Override
  public MqttClientOptions setPemKeyCertOptions(PemKeyCertOptions options) {
     super.setPemKeyCertOptions(options);
     return this;
  }

  @Override
  public MqttClientOptions setTrustOptions(TrustOptions options) {
     super.setTrustOptions(options);
     return this;
  }

  @Override
  public MqttClientOptions setPemTrustOptions(PemTrustOptions options) {
     super.setPemTrustOptions(options);
     return this;
  }

  @Override
  public MqttClientOptions setPfxTrustOptions(PfxOptions options) {
     super.setPfxTrustOptions(options);
     return this;
  }

  @Override
  public MqttClientOptions addEnabledCipherSuite(String suite) {
     super.addEnabledCipherSuite(suite);
     return this;
  }

  @Override
  public MqttClientOptions addEnabledSecureTransportProtocol(String protocol) {
     super.addEnabledSecureTransportProtocol(protocol);
     return this;
  }

  @Override
  public MqttClientOptions addCrlPath(String crlPath) throws NullPointerException {
     super.addCrlPath(crlPath);
     return this;
  }

  @Override
  public MqttClientOptions addCrlValue(Buffer crlValue) throws NullPointerException {
     super.addCrlValue(crlValue);
     return this;
  }

  @Override
  public String toString() {
    return "Options {" +
      "clientId='" + clientId + '\'' +
      ", username='" + username + '\'' +
      ", password='" + password + '\'' +
      ", willTopic='" + willTopic + '\'' +
      ", willMessage='" + willMessage + '\'' +
      ", cleanSession=" + cleanSession +
      ", willFlag=" + willFlag +
      ", willQoS=" + willQoS +
      ", willRetain=" + willRetain +
      ", keepAliveTimeSeconds=" + keepAliveTimeSeconds +
      ", isAutoKeepAlive=" + isAutoKeepAlive +
      ", isAutoGeneratedClientId=" + isAutoGeneratedClientId +
      '}';
  }
}
