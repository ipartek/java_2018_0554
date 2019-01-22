/**
 * Pub_gralSoapStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package UASI.WS_GRAL_wsdl;

public class Pub_gralSoapStub extends org.apache.axis.client.Stub implements UASI.WS_GRAL_wsdl.Pub_gralSoap {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[5];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("wsnoticias");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "plengua"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "pfechaini"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "ArrayOfClaseNoticias"));
        oper.setReturnClass(UASI.WS_GRAL_wsdl.ClaseNoticias[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "wsnoticiasResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "ClaseNoticias"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("wsdiasfestivos");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "plengua"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "pcurso"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "ArrayOfClaseDiasFestivos"));
        oper.setReturnClass(UASI.WS_GRAL_wsdl.ClaseDiasFestivos[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "wsdiasfestivosResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "ClaseDiasFestivos"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("wsx500");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "plengua"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "ptexto"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "ArrayOfClaseX500"));
        oper.setReturnClass(UASI.WS_GRAL_wsdl.ClaseX500[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "wsx500Result"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "ClaseX500"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("wsalojamientos");
        oper.setReturnType(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "ArrayOfClaseAlojamiento"));
        oper.setReturnClass(UASI.WS_GRAL_wsdl.ClaseAlojamiento[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "wsalojamientosResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "ClaseAlojamiento"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("wsvideo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "plengua"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "pfechadesde"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "ArrayOfClaseVideo"));
        oper.setReturnClass(UASI.WS_GRAL_wsdl.ClaseVideo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "wsvideoResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "ClaseVideo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

    }

    public Pub_gralSoapStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public Pub_gralSoapStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public Pub_gralSoapStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "ArrayOfClaseAlojamiento");
            cachedSerQNames.add(qName);
            cls = UASI.WS_GRAL_wsdl.ClaseAlojamiento[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "ClaseAlojamiento");
            qName2 = new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "ClaseAlojamiento");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "ArrayOfClaseDiasFestivos");
            cachedSerQNames.add(qName);
            cls = UASI.WS_GRAL_wsdl.ClaseDiasFestivos[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "ClaseDiasFestivos");
            qName2 = new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "ClaseDiasFestivos");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "ArrayOfClaseNoticias");
            cachedSerQNames.add(qName);
            cls = UASI.WS_GRAL_wsdl.ClaseNoticias[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "ClaseNoticias");
            qName2 = new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "ClaseNoticias");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "ArrayOfClaseVideo");
            cachedSerQNames.add(qName);
            cls = UASI.WS_GRAL_wsdl.ClaseVideo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "ClaseVideo");
            qName2 = new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "ClaseVideo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "ArrayOfClaseX500");
            cachedSerQNames.add(qName);
            cls = UASI.WS_GRAL_wsdl.ClaseX500[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "ClaseX500");
            qName2 = new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "ClaseX500");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "ClaseAlojamiento");
            cachedSerQNames.add(qName);
            cls = UASI.WS_GRAL_wsdl.ClaseAlojamiento.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "ClaseDiasFestivos");
            cachedSerQNames.add(qName);
            cls = UASI.WS_GRAL_wsdl.ClaseDiasFestivos.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "ClaseNoticias");
            cachedSerQNames.add(qName);
            cls = UASI.WS_GRAL_wsdl.ClaseNoticias.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "ClaseVideo");
            cachedSerQNames.add(qName);
            cls = UASI.WS_GRAL_wsdl.ClaseVideo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "ClaseX500");
            cachedSerQNames.add(qName);
            cls = UASI.WS_GRAL_wsdl.ClaseX500.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public UASI.WS_GRAL_wsdl.ClaseNoticias[] wsnoticias(java.lang.String plengua, java.lang.String pfechaini) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://UASI/WS_GRAL.wsdl/wsnoticias");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "wsnoticias"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {plengua, pfechaini});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (UASI.WS_GRAL_wsdl.ClaseNoticias[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (UASI.WS_GRAL_wsdl.ClaseNoticias[]) org.apache.axis.utils.JavaUtils.convert(_resp, UASI.WS_GRAL_wsdl.ClaseNoticias[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public UASI.WS_GRAL_wsdl.ClaseDiasFestivos[] wsdiasfestivos(java.lang.String plengua, java.lang.String pcurso) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://UASI/WS_GRAL.wsdl/wsdiasfestivos");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "wsdiasfestivos"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {plengua, pcurso});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (UASI.WS_GRAL_wsdl.ClaseDiasFestivos[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (UASI.WS_GRAL_wsdl.ClaseDiasFestivos[]) org.apache.axis.utils.JavaUtils.convert(_resp, UASI.WS_GRAL_wsdl.ClaseDiasFestivos[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public UASI.WS_GRAL_wsdl.ClaseX500[] wsx500(java.lang.String plengua, java.lang.String ptexto) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://UASI/WS_GRAL.wsdl/wsx500");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "wsx500"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {plengua, ptexto});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (UASI.WS_GRAL_wsdl.ClaseX500[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (UASI.WS_GRAL_wsdl.ClaseX500[]) org.apache.axis.utils.JavaUtils.convert(_resp, UASI.WS_GRAL_wsdl.ClaseX500[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public UASI.WS_GRAL_wsdl.ClaseAlojamiento[] wsalojamientos() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://UASI/WS_GRAL.wsdl/wsalojamientos");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "wsalojamientos"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (UASI.WS_GRAL_wsdl.ClaseAlojamiento[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (UASI.WS_GRAL_wsdl.ClaseAlojamiento[]) org.apache.axis.utils.JavaUtils.convert(_resp, UASI.WS_GRAL_wsdl.ClaseAlojamiento[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public UASI.WS_GRAL_wsdl.ClaseVideo[] wsvideo(java.lang.String plengua, java.lang.String pfechadesde) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://UASI/WS_GRAL.wsdl/wsvideo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://UASI/WS_GRAL.wsdl", "wsvideo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {plengua, pfechadesde});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (UASI.WS_GRAL_wsdl.ClaseVideo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (UASI.WS_GRAL_wsdl.ClaseVideo[]) org.apache.axis.utils.JavaUtils.convert(_resp, UASI.WS_GRAL_wsdl.ClaseVideo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
