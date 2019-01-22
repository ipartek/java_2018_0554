/**
 * ClaseNoticias.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package UASI.WS_GRAL_wsdl;

public class ClaseNoticias  implements java.io.Serializable {
    private int idnoticia;

    private java.lang.String titulo;

    private java.lang.String contenido;

    private java.lang.String url;

    private java.lang.String imagen;

    private java.util.Calendar fechapublicacion;

    private java.lang.String tipo;

    private int idsitio;

    private java.lang.String nombresitio;

    public ClaseNoticias() {
    }

    public ClaseNoticias(
           int idnoticia,
           java.lang.String titulo,
           java.lang.String contenido,
           java.lang.String url,
           java.lang.String imagen,
           java.util.Calendar fechapublicacion,
           java.lang.String tipo,
           int idsitio,
           java.lang.String nombresitio) {
           this.idnoticia = idnoticia;
           this.titulo = titulo;
           this.contenido = contenido;
           this.url = url;
           this.imagen = imagen;
           this.fechapublicacion = fechapublicacion;
           this.tipo = tipo;
           this.idsitio = idsitio;
           this.nombresitio = nombresitio;
    }


    /**
     * Gets the idnoticia value for this ClaseNoticias.
     * 
     * @return idnoticia
     */
    public int getIdnoticia() {
        return idnoticia;
    }


    /**
     * Sets the idnoticia value for this ClaseNoticias.
     * 
     * @param idnoticia
     */
    public void setIdnoticia(int idnoticia) {
        this.idnoticia = idnoticia;
    }


    /**
     * Gets the titulo value for this ClaseNoticias.
     * 
     * @return titulo
     */
    public java.lang.String getTitulo() {
        return titulo;
    }


    /**
     * Sets the titulo value for this ClaseNoticias.
     * 
     * @param titulo
     */
    public void setTitulo(java.lang.String titulo) {
        this.titulo = titulo;
    }


    /**
     * Gets the contenido value for this ClaseNoticias.
     * 
     * @return contenido
     */
    public java.lang.String getContenido() {
        return contenido;
    }


    /**
     * Sets the contenido value for this ClaseNoticias.
     * 
     * @param contenido
     */
    public void setContenido(java.lang.String contenido) {
        this.contenido = contenido;
    }


    /**
     * Gets the url value for this ClaseNoticias.
     * 
     * @return url
     */
    public java.lang.String getUrl() {
        return url;
    }


    /**
     * Sets the url value for this ClaseNoticias.
     * 
     * @param url
     */
    public void setUrl(java.lang.String url) {
        this.url = url;
    }


    /**
     * Gets the imagen value for this ClaseNoticias.
     * 
     * @return imagen
     */
    public java.lang.String getImagen() {
        return imagen;
    }


    /**
     * Sets the imagen value for this ClaseNoticias.
     * 
     * @param imagen
     */
    public void setImagen(java.lang.String imagen) {
        this.imagen = imagen;
    }


    /**
     * Gets the fechapublicacion value for this ClaseNoticias.
     * 
     * @return fechapublicacion
     */
    public java.util.Calendar getFechapublicacion() {
        return fechapublicacion;
    }


    /**
     * Sets the fechapublicacion value for this ClaseNoticias.
     * 
     * @param fechapublicacion
     */
    public void setFechapublicacion(java.util.Calendar fechapublicacion) {
        this.fechapublicacion = fechapublicacion;
    }


    /**
     * Gets the tipo value for this ClaseNoticias.
     * 
     * @return tipo
     */
    public java.lang.String getTipo() {
        return tipo;
    }


    /**
     * Sets the tipo value for this ClaseNoticias.
     * 
     * @param tipo
     */
    public void setTipo(java.lang.String tipo) {
        this.tipo = tipo;
    }


    /**
     * Gets the idsitio value for this ClaseNoticias.
     * 
     * @return idsitio
     */
    public int getIdsitio() {
        return idsitio;
    }


    /**
     * Sets the idsitio value for this ClaseNoticias.
     * 
     * @param idsitio
     */
    public void setIdsitio(int idsitio) {
        this.idsitio = idsitio;
    }


    /**
     * Gets the nombresitio value for this ClaseNoticias.
     * 
     * @return nombresitio
     */
    public java.lang.String getNombresitio() {
        return nombresitio;
    }


    /**
     * Sets the nombresitio value for this ClaseNoticias.
     * 
     * @param nombresitio
     */
    public void setNombresitio(java.lang.String nombresitio) {
        this.nombresitio = nombresitio;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ClaseNoticias)) return false;
        ClaseNoticias other = (ClaseNoticias) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idnoticia == other.getIdnoticia() &&
            ((this.titulo==null && other.getTitulo()==null) || 
             (this.titulo!=null &&
              this.titulo.equals(other.getTitulo()))) &&
            ((this.contenido==null && other.getContenido()==null) || 
             (this.contenido!=null &&
              this.contenido.equals(other.getContenido()))) &&
            ((this.url==null && other.getUrl()==null) || 
             (this.url!=null &&
              this.url.equals(other.getUrl()))) &&
            ((this.imagen==null && other.getImagen()==null) || 
             (this.imagen!=null &&
              this.imagen.equals(other.getImagen()))) &&
            ((this.fechapublicacion==null && other.getFechapublicacion()==null) || 
             (this.fechapublicacion!=null &&
              this.fechapublicacion.equals(other.getFechapublicacion()))) &&
            ((this.tipo==null && other.getTipo()==null) || 
             (this.tipo!=null &&
              this.tipo.equals(other.getTipo()))) &&
            this.idsitio == other.getIdsitio() &&
            ((this.nombresitio==null && other.getNombresitio()==null) || 
             (this.nombresitio!=null &&
              this.nombresitio.equals(other.getNombresitio())));
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
        _hashCode += getIdnoticia();
        if (getTitulo() != null) {
            _hashCode += getTitulo().hashCode();
        }
        if (getContenido() != null) {
            _hashCode += getContenido().hashCode();
        }
        if (getUrl() != null) {
            _hashCode += getUrl().hashCode();
        }
        if (getImagen() != null) {
            _hashCode += getImagen().hashCode();
        }
        if (getFechapublicacion() != null) {
            _hashCode += getFechapublicacion().hashCode();
        }
        if (getTipo() != null) {
            _hashCode += getTipo().hashCode();
        }
        _hashCode += getIdsitio();
        if (getNombresitio() != null) {
            _hashCode += getNombresitio().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ClaseNoticias.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "ClaseNoticias"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idnoticia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "idnoticia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("titulo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "titulo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contenido");
        elemField.setXmlName(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "contenido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("url");
        elemField.setXmlName(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "url"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("imagen");
        elemField.setXmlName(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "imagen"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechapublicacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "fechapublicacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
        elemField.setFieldName("idsitio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "idsitio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombresitio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "nombresitio"));
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
