/**
 * ClaseDiasFestivos.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package UASI.WS_GRAL_wsdl;

public class ClaseDiasFestivos  implements java.io.Serializable {
    private java.lang.String caca;

    private java.lang.String fechaini;

    private java.lang.String fechafin;

    private java.lang.String descripcion;

    private java.lang.String ambito;

    private java.lang.String nomambito;

    private java.lang.String tipo;

    private java.lang.String nomtipo;

    private java.lang.String codcen;

    public ClaseDiasFestivos() {
    }

    public ClaseDiasFestivos(
           java.lang.String caca,
           java.lang.String fechaini,
           java.lang.String fechafin,
           java.lang.String descripcion,
           java.lang.String ambito,
           java.lang.String nomambito,
           java.lang.String tipo,
           java.lang.String nomtipo,
           java.lang.String codcen) {
           this.caca = caca;
           this.fechaini = fechaini;
           this.fechafin = fechafin;
           this.descripcion = descripcion;
           this.ambito = ambito;
           this.nomambito = nomambito;
           this.tipo = tipo;
           this.nomtipo = nomtipo;
           this.codcen = codcen;
    }


    /**
     * Gets the caca value for this ClaseDiasFestivos.
     * 
     * @return caca
     */
    public java.lang.String getCaca() {
        return caca;
    }


    /**
     * Sets the caca value for this ClaseDiasFestivos.
     * 
     * @param caca
     */
    public void setCaca(java.lang.String caca) {
        this.caca = caca;
    }


    /**
     * Gets the fechaini value for this ClaseDiasFestivos.
     * 
     * @return fechaini
     */
    public java.lang.String getFechaini() {
        return fechaini;
    }


    /**
     * Sets the fechaini value for this ClaseDiasFestivos.
     * 
     * @param fechaini
     */
    public void setFechaini(java.lang.String fechaini) {
        this.fechaini = fechaini;
    }


    /**
     * Gets the fechafin value for this ClaseDiasFestivos.
     * 
     * @return fechafin
     */
    public java.lang.String getFechafin() {
        return fechafin;
    }


    /**
     * Sets the fechafin value for this ClaseDiasFestivos.
     * 
     * @param fechafin
     */
    public void setFechafin(java.lang.String fechafin) {
        this.fechafin = fechafin;
    }


    /**
     * Gets the descripcion value for this ClaseDiasFestivos.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this ClaseDiasFestivos.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the ambito value for this ClaseDiasFestivos.
     * 
     * @return ambito
     */
    public java.lang.String getAmbito() {
        return ambito;
    }


    /**
     * Sets the ambito value for this ClaseDiasFestivos.
     * 
     * @param ambito
     */
    public void setAmbito(java.lang.String ambito) {
        this.ambito = ambito;
    }


    /**
     * Gets the nomambito value for this ClaseDiasFestivos.
     * 
     * @return nomambito
     */
    public java.lang.String getNomambito() {
        return nomambito;
    }


    /**
     * Sets the nomambito value for this ClaseDiasFestivos.
     * 
     * @param nomambito
     */
    public void setNomambito(java.lang.String nomambito) {
        this.nomambito = nomambito;
    }


    /**
     * Gets the tipo value for this ClaseDiasFestivos.
     * 
     * @return tipo
     */
    public java.lang.String getTipo() {
        return tipo;
    }


    /**
     * Sets the tipo value for this ClaseDiasFestivos.
     * 
     * @param tipo
     */
    public void setTipo(java.lang.String tipo) {
        this.tipo = tipo;
    }


    /**
     * Gets the nomtipo value for this ClaseDiasFestivos.
     * 
     * @return nomtipo
     */
    public java.lang.String getNomtipo() {
        return nomtipo;
    }


    /**
     * Sets the nomtipo value for this ClaseDiasFestivos.
     * 
     * @param nomtipo
     */
    public void setNomtipo(java.lang.String nomtipo) {
        this.nomtipo = nomtipo;
    }


    /**
     * Gets the codcen value for this ClaseDiasFestivos.
     * 
     * @return codcen
     */
    public java.lang.String getCodcen() {
        return codcen;
    }


    /**
     * Sets the codcen value for this ClaseDiasFestivos.
     * 
     * @param codcen
     */
    public void setCodcen(java.lang.String codcen) {
        this.codcen = codcen;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ClaseDiasFestivos)) return false;
        ClaseDiasFestivos other = (ClaseDiasFestivos) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.caca==null && other.getCaca()==null) || 
             (this.caca!=null &&
              this.caca.equals(other.getCaca()))) &&
            ((this.fechaini==null && other.getFechaini()==null) || 
             (this.fechaini!=null &&
              this.fechaini.equals(other.getFechaini()))) &&
            ((this.fechafin==null && other.getFechafin()==null) || 
             (this.fechafin!=null &&
              this.fechafin.equals(other.getFechafin()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.ambito==null && other.getAmbito()==null) || 
             (this.ambito!=null &&
              this.ambito.equals(other.getAmbito()))) &&
            ((this.nomambito==null && other.getNomambito()==null) || 
             (this.nomambito!=null &&
              this.nomambito.equals(other.getNomambito()))) &&
            ((this.tipo==null && other.getTipo()==null) || 
             (this.tipo!=null &&
              this.tipo.equals(other.getTipo()))) &&
            ((this.nomtipo==null && other.getNomtipo()==null) || 
             (this.nomtipo!=null &&
              this.nomtipo.equals(other.getNomtipo()))) &&
            ((this.codcen==null && other.getCodcen()==null) || 
             (this.codcen!=null &&
              this.codcen.equals(other.getCodcen())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCaca() != null) {
            _hashCode += getCaca().hashCode();
        }
        if (getFechaini() != null) {
            _hashCode += getFechaini().hashCode();
        }
        if (getFechafin() != null) {
            _hashCode += getFechafin().hashCode();
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getAmbito() != null) {
            _hashCode += getAmbito().hashCode();
        }
        if (getNomambito() != null) {
            _hashCode += getNomambito().hashCode();
        }
        if (getTipo() != null) {
            _hashCode += getTipo().hashCode();
        }
        if (getNomtipo() != null) {
            _hashCode += getNomtipo().hashCode();
        }
        if (getCodcen() != null) {
            _hashCode += getCodcen().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ClaseDiasFestivos.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "ClaseDiasFestivos"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("caca");
        elemField.setXmlName(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "caca"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaini");
        elemField.setXmlName(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "fechaini"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechafin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "fechafin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ambito");
        elemField.setXmlName(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "ambito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomambito");
        elemField.setXmlName(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "nomambito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "tipo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomtipo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "nomtipo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codcen");
        elemField.setXmlName(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "codcen"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
