// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pb_transfer.proto

package com.hyr.disruptor.pb;

public final class PbTransfer {
  private PbTransfer() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface PvDataOrBuilder extends
      // @@protoc_insertion_point(interface_extends:PvData.PvData)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required string pvid = 1;</code>
     *
     * <pre>
     *数据标识
     * </pre>
     */
    boolean hasPvid();
    /**
     * <code>required string pvid = 1;</code>
     *
     * <pre>
     *数据标识
     * </pre>
     */
    java.lang.String getPvid();
    /**
     * <code>required string pvid = 1;</code>
     *
     * <pre>
     *数据标识
     * </pre>
     */
    com.google.protobuf.ByteString
        getPvidBytes();

    /**
     * <code>required uint64 index = 2;</code>
     *
     * <pre>
     *数据包索引
     * </pre>
     */
    boolean hasIndex();
    /**
     * <code>required uint64 index = 2;</code>
     *
     * <pre>
     *数据包索引
     * </pre>
     */
    long getIndex();

    /**
     * <code>required string producer = 3;</code>
     *
     * <pre>
     *生产者
     * </pre>
     */
    boolean hasProducer();
    /**
     * <code>required string producer = 3;</code>
     *
     * <pre>
     *生产者
     * </pre>
     */
    java.lang.String getProducer();
    /**
     * <code>required string producer = 3;</code>
     *
     * <pre>
     *生产者
     * </pre>
     */
    com.google.protobuf.ByteString
        getProducerBytes();

    /**
     * <code>required uint64 monitorTime = 4;</code>
     *
     * <pre>
     * 数据时间戳
     * </pre>
     */
    boolean hasMonitorTime();
    /**
     * <code>required uint64 monitorTime = 4;</code>
     *
     * <pre>
     * 数据时间戳
     * </pre>
     */
    long getMonitorTime();
  }
  /**
   * Protobuf type {@code PvData.PvData}
   *
   * <pre>
   * 数据包
   * </pre>
   */
  public static final class PvData extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:PvData.PvData)
      PvDataOrBuilder {
    // Use PvData.newBuilder() to construct.
    private PvData(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private PvData(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final PvData defaultInstance;
    public static PvData getDefaultInstance() {
      return defaultInstance;
    }

    public PvData getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private PvData(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000001;
              pvid_ = bs;
              break;
            }
            case 16: {
              bitField0_ |= 0x00000002;
              index_ = input.readUInt64();
              break;
            }
            case 26: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000004;
              producer_ = bs;
              break;
            }
            case 32: {
              bitField0_ |= 0x00000008;
              monitorTime_ = input.readUInt64();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.hyr.disruptor.pb.PbTransfer.internal_static_PvData_PvData_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.hyr.disruptor.pb.PbTransfer.internal_static_PvData_PvData_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.hyr.disruptor.pb.PbTransfer.PvData.class, com.hyr.disruptor.pb.PbTransfer.PvData.Builder.class);
    }

    public static com.google.protobuf.Parser<PvData> PARSER =
        new com.google.protobuf.AbstractParser<PvData>() {
      public PvData parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new PvData(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<PvData> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    public static final int PVID_FIELD_NUMBER = 1;
    private java.lang.Object pvid_;
    /**
     * <code>required string pvid = 1;</code>
     *
     * <pre>
     *数据标识
     * </pre>
     */
    public boolean hasPvid() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required string pvid = 1;</code>
     *
     * <pre>
     *数据标识
     * </pre>
     */
    public java.lang.String getPvid() {
      java.lang.Object ref = pvid_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          pvid_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string pvid = 1;</code>
     *
     * <pre>
     *数据标识
     * </pre>
     */
    public com.google.protobuf.ByteString
        getPvidBytes() {
      java.lang.Object ref = pvid_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        pvid_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int INDEX_FIELD_NUMBER = 2;
    private long index_;
    /**
     * <code>required uint64 index = 2;</code>
     *
     * <pre>
     *数据包索引
     * </pre>
     */
    public boolean hasIndex() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required uint64 index = 2;</code>
     *
     * <pre>
     *数据包索引
     * </pre>
     */
    public long getIndex() {
      return index_;
    }

    public static final int PRODUCER_FIELD_NUMBER = 3;
    private java.lang.Object producer_;
    /**
     * <code>required string producer = 3;</code>
     *
     * <pre>
     *生产者
     * </pre>
     */
    public boolean hasProducer() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>required string producer = 3;</code>
     *
     * <pre>
     *生产者
     * </pre>
     */
    public java.lang.String getProducer() {
      java.lang.Object ref = producer_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          producer_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string producer = 3;</code>
     *
     * <pre>
     *生产者
     * </pre>
     */
    public com.google.protobuf.ByteString
        getProducerBytes() {
      java.lang.Object ref = producer_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        producer_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int MONITORTIME_FIELD_NUMBER = 4;
    private long monitorTime_;
    /**
     * <code>required uint64 monitorTime = 4;</code>
     *
     * <pre>
     * 数据时间戳
     * </pre>
     */
    public boolean hasMonitorTime() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>required uint64 monitorTime = 4;</code>
     *
     * <pre>
     * 数据时间戳
     * </pre>
     */
    public long getMonitorTime() {
      return monitorTime_;
    }

    private void initFields() {
      pvid_ = "";
      index_ = 0L;
      producer_ = "";
      monitorTime_ = 0L;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasPvid()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasIndex()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasProducer()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasMonitorTime()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeBytes(1, getPvidBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeUInt64(2, index_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeBytes(3, getProducerBytes());
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        output.writeUInt64(4, monitorTime_);
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, getPvidBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt64Size(2, index_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(3, getProducerBytes());
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt64Size(4, monitorTime_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static com.hyr.disruptor.pb.PbTransfer.PvData parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.hyr.disruptor.pb.PbTransfer.PvData parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.hyr.disruptor.pb.PbTransfer.PvData parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.hyr.disruptor.pb.PbTransfer.PvData parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.hyr.disruptor.pb.PbTransfer.PvData parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.hyr.disruptor.pb.PbTransfer.PvData parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static com.hyr.disruptor.pb.PbTransfer.PvData parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static com.hyr.disruptor.pb.PbTransfer.PvData parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static com.hyr.disruptor.pb.PbTransfer.PvData parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.hyr.disruptor.pb.PbTransfer.PvData parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.hyr.disruptor.pb.PbTransfer.PvData prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code PvData.PvData}
     *
     * <pre>
     * 数据包
     * </pre>
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:PvData.PvData)
        com.hyr.disruptor.pb.PbTransfer.PvDataOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.hyr.disruptor.pb.PbTransfer.internal_static_PvData_PvData_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.hyr.disruptor.pb.PbTransfer.internal_static_PvData_PvData_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.hyr.disruptor.pb.PbTransfer.PvData.class, com.hyr.disruptor.pb.PbTransfer.PvData.Builder.class);
      }

      // Construct using com.hyr.disruptor.pb.PbTransfer.PvData.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        pvid_ = "";
        bitField0_ = (bitField0_ & ~0x00000001);
        index_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000002);
        producer_ = "";
        bitField0_ = (bitField0_ & ~0x00000004);
        monitorTime_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000008);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.hyr.disruptor.pb.PbTransfer.internal_static_PvData_PvData_descriptor;
      }

      public com.hyr.disruptor.pb.PbTransfer.PvData getDefaultInstanceForType() {
        return com.hyr.disruptor.pb.PbTransfer.PvData.getDefaultInstance();
      }

      public com.hyr.disruptor.pb.PbTransfer.PvData build() {
        com.hyr.disruptor.pb.PbTransfer.PvData result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.hyr.disruptor.pb.PbTransfer.PvData buildPartial() {
        com.hyr.disruptor.pb.PbTransfer.PvData result = new com.hyr.disruptor.pb.PbTransfer.PvData(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.pvid_ = pvid_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.index_ = index_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.producer_ = producer_;
        if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
          to_bitField0_ |= 0x00000008;
        }
        result.monitorTime_ = monitorTime_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.hyr.disruptor.pb.PbTransfer.PvData) {
          return mergeFrom((com.hyr.disruptor.pb.PbTransfer.PvData)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.hyr.disruptor.pb.PbTransfer.PvData other) {
        if (other == com.hyr.disruptor.pb.PbTransfer.PvData.getDefaultInstance()) return this;
        if (other.hasPvid()) {
          bitField0_ |= 0x00000001;
          pvid_ = other.pvid_;
          onChanged();
        }
        if (other.hasIndex()) {
          setIndex(other.getIndex());
        }
        if (other.hasProducer()) {
          bitField0_ |= 0x00000004;
          producer_ = other.producer_;
          onChanged();
        }
        if (other.hasMonitorTime()) {
          setMonitorTime(other.getMonitorTime());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasPvid()) {
          
          return false;
        }
        if (!hasIndex()) {
          
          return false;
        }
        if (!hasProducer()) {
          
          return false;
        }
        if (!hasMonitorTime()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.hyr.disruptor.pb.PbTransfer.PvData parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.hyr.disruptor.pb.PbTransfer.PvData) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private java.lang.Object pvid_ = "";
      /**
       * <code>required string pvid = 1;</code>
       *
       * <pre>
       *数据标识
       * </pre>
       */
      public boolean hasPvid() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required string pvid = 1;</code>
       *
       * <pre>
       *数据标识
       * </pre>
       */
      public java.lang.String getPvid() {
        java.lang.Object ref = pvid_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            pvid_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string pvid = 1;</code>
       *
       * <pre>
       *数据标识
       * </pre>
       */
      public com.google.protobuf.ByteString
          getPvidBytes() {
        java.lang.Object ref = pvid_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          pvid_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string pvid = 1;</code>
       *
       * <pre>
       *数据标识
       * </pre>
       */
      public Builder setPvid(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        pvid_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string pvid = 1;</code>
       *
       * <pre>
       *数据标识
       * </pre>
       */
      public Builder clearPvid() {
        bitField0_ = (bitField0_ & ~0x00000001);
        pvid_ = getDefaultInstance().getPvid();
        onChanged();
        return this;
      }
      /**
       * <code>required string pvid = 1;</code>
       *
       * <pre>
       *数据标识
       * </pre>
       */
      public Builder setPvidBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        pvid_ = value;
        onChanged();
        return this;
      }

      private long index_ ;
      /**
       * <code>required uint64 index = 2;</code>
       *
       * <pre>
       *数据包索引
       * </pre>
       */
      public boolean hasIndex() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required uint64 index = 2;</code>
       *
       * <pre>
       *数据包索引
       * </pre>
       */
      public long getIndex() {
        return index_;
      }
      /**
       * <code>required uint64 index = 2;</code>
       *
       * <pre>
       *数据包索引
       * </pre>
       */
      public Builder setIndex(long value) {
        bitField0_ |= 0x00000002;
        index_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required uint64 index = 2;</code>
       *
       * <pre>
       *数据包索引
       * </pre>
       */
      public Builder clearIndex() {
        bitField0_ = (bitField0_ & ~0x00000002);
        index_ = 0L;
        onChanged();
        return this;
      }

      private java.lang.Object producer_ = "";
      /**
       * <code>required string producer = 3;</code>
       *
       * <pre>
       *生产者
       * </pre>
       */
      public boolean hasProducer() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>required string producer = 3;</code>
       *
       * <pre>
       *生产者
       * </pre>
       */
      public java.lang.String getProducer() {
        java.lang.Object ref = producer_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            producer_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string producer = 3;</code>
       *
       * <pre>
       *生产者
       * </pre>
       */
      public com.google.protobuf.ByteString
          getProducerBytes() {
        java.lang.Object ref = producer_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          producer_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string producer = 3;</code>
       *
       * <pre>
       *生产者
       * </pre>
       */
      public Builder setProducer(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        producer_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string producer = 3;</code>
       *
       * <pre>
       *生产者
       * </pre>
       */
      public Builder clearProducer() {
        bitField0_ = (bitField0_ & ~0x00000004);
        producer_ = getDefaultInstance().getProducer();
        onChanged();
        return this;
      }
      /**
       * <code>required string producer = 3;</code>
       *
       * <pre>
       *生产者
       * </pre>
       */
      public Builder setProducerBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        producer_ = value;
        onChanged();
        return this;
      }

      private long monitorTime_ ;
      /**
       * <code>required uint64 monitorTime = 4;</code>
       *
       * <pre>
       * 数据时间戳
       * </pre>
       */
      public boolean hasMonitorTime() {
        return ((bitField0_ & 0x00000008) == 0x00000008);
      }
      /**
       * <code>required uint64 monitorTime = 4;</code>
       *
       * <pre>
       * 数据时间戳
       * </pre>
       */
      public long getMonitorTime() {
        return monitorTime_;
      }
      /**
       * <code>required uint64 monitorTime = 4;</code>
       *
       * <pre>
       * 数据时间戳
       * </pre>
       */
      public Builder setMonitorTime(long value) {
        bitField0_ |= 0x00000008;
        monitorTime_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required uint64 monitorTime = 4;</code>
       *
       * <pre>
       * 数据时间戳
       * </pre>
       */
      public Builder clearMonitorTime() {
        bitField0_ = (bitField0_ & ~0x00000008);
        monitorTime_ = 0L;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:PvData.PvData)
    }

    static {
      defaultInstance = new PvData(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:PvData.PvData)
  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_PvData_PvData_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_PvData_PvData_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021pb_transfer.proto\022\006PvData\"L\n\006PvData\022\014\n" +
      "\004pvid\030\001 \002(\t\022\r\n\005index\030\002 \002(\004\022\020\n\010producer\030\003" +
      " \002(\t\022\023\n\013monitorTime\030\004 \002(\004B\026\n\024com.hyr.dis" +
      "ruptor.pb"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_PvData_PvData_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_PvData_PvData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_PvData_PvData_descriptor,
        new java.lang.String[] { "Pvid", "Index", "Producer", "MonitorTime", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
