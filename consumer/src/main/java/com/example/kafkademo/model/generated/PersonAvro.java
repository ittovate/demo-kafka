/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.example.kafkademo.model.generated;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class PersonAvro extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -3605281941689467784L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"PersonAvro\",\"namespace\":\"com.example.kafka_demo.model.generated\",\"fields\":[{\"name\":\"name\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"age\",\"type\":[\"null\",\"int\"],\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<PersonAvro> ENCODER =
      new BinaryMessageEncoder<PersonAvro>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<PersonAvro> DECODER =
      new BinaryMessageDecoder<PersonAvro>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<PersonAvro> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<PersonAvro> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<PersonAvro>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this PersonAvro to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a PersonAvro from a ByteBuffer. */
  public static PersonAvro fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.CharSequence name;
  @Deprecated public java.lang.Integer age;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public PersonAvro() {}

  /**
   * All-args constructor.
   * @param name The new value for name
   * @param age The new value for age
   */
  public PersonAvro(java.lang.CharSequence name, java.lang.Integer age) {
    this.name = name;
    this.age = age;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return name;
    case 1: return age;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: name = (java.lang.CharSequence)value$; break;
    case 1: age = (java.lang.Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'name' field.
   * @return The value of the 'name' field.
   */
  public java.lang.CharSequence getName() {
    return name;
  }

  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.CharSequence value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'age' field.
   * @return The value of the 'age' field.
   */
  public java.lang.Integer getAge() {
    return age;
  }

  /**
   * Sets the value of the 'age' field.
   * @param value the value to set.
   */
  public void setAge(java.lang.Integer value) {
    this.age = value;
  }

  /**
   * Creates a new PersonAvro RecordBuilder.
   * @return A new PersonAvro RecordBuilder
   */
  public static com.example.kafkademo.model.generated.PersonAvro.Builder newBuilder() {
    return new com.example.kafkademo.model.generated.PersonAvro.Builder();
  }

  /**
   * Creates a new PersonAvro RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new PersonAvro RecordBuilder
   */
  public static com.example.kafkademo.model.generated.PersonAvro.Builder newBuilder(com.example.kafkademo.model.generated.PersonAvro.Builder other) {
    return new com.example.kafkademo.model.generated.PersonAvro.Builder(other);
  }

  /**
   * Creates a new PersonAvro RecordBuilder by copying an existing PersonAvro instance.
   * @param other The existing instance to copy.
   * @return A new PersonAvro RecordBuilder
   */
  public static com.example.kafkademo.model.generated.PersonAvro.Builder newBuilder(com.example.kafkademo.model.generated.PersonAvro other) {
    return new com.example.kafkademo.model.generated.PersonAvro.Builder(other);
  }

  /**
   * RecordBuilder for PersonAvro instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<PersonAvro>
    implements org.apache.avro.data.RecordBuilder<PersonAvro> {

    private java.lang.CharSequence name;
    private java.lang.Integer age;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.example.kafkademo.model.generated.PersonAvro.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.age)) {
        this.age = data().deepCopy(fields()[1].schema(), other.age);
        fieldSetFlags()[1] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing PersonAvro instance
     * @param other The existing instance to copy.
     */
    private Builder(com.example.kafkademo.model.generated.PersonAvro other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.age)) {
        this.age = data().deepCopy(fields()[1].schema(), other.age);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public java.lang.CharSequence getName() {
      return name;
    }

    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public com.example.kafkademo.model.generated.PersonAvro.Builder setName(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.name = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public com.example.kafkademo.model.generated.PersonAvro.Builder clearName() {
      name = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'age' field.
      * @return The value.
      */
    public java.lang.Integer getAge() {
      return age;
    }

    /**
      * Sets the value of the 'age' field.
      * @param value The value of 'age'.
      * @return This builder.
      */
    public com.example.kafkademo.model.generated.PersonAvro.Builder setAge(java.lang.Integer value) {
      validate(fields()[1], value);
      this.age = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'age' field has been set.
      * @return True if the 'age' field has been set, false otherwise.
      */
    public boolean hasAge() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'age' field.
      * @return This builder.
      */
    public com.example.kafkademo.model.generated.PersonAvro.Builder clearAge() {
      age = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public PersonAvro build() {
      try {
        PersonAvro record = new PersonAvro();
        record.name = fieldSetFlags()[0] ? this.name : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.age = fieldSetFlags()[1] ? this.age : (java.lang.Integer) defaultValue(fields()[1]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<PersonAvro>
    WRITER$ = (org.apache.avro.io.DatumWriter<PersonAvro>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<PersonAvro>
    READER$ = (org.apache.avro.io.DatumReader<PersonAvro>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}