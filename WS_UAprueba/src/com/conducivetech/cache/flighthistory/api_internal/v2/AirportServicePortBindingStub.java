/**
 * AirportServicePortBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.conducivetech.cache.flighthistory.api_internal.v2;

public class AirportServicePortBindingStub extends org.apache.axis.client.Stub implements com.conducivetech.cache.flighthistory.api_internal.v2.AirportService {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[4];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("airportStatus_arr");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "appId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "appKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "airport"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "year"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "month"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "day"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hourOfDay"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), java.lang.Integer.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "utc"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), java.lang.Boolean.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "numHours"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), java.lang.Integer.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "carrier"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "codeType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "maxFlights"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), java.lang.Integer.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "extendedOptions"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "responseAirportStatus"));
        oper.setReturnClass(com.conducivetech.cache.flighthistory.api_internal.v2.ResponseAirportStatus.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "APIException"),
                      "com.conducivetech.cache.flighthistory.api_internal.v2.APIException",
                      new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "APIException"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("airportTracks_arr");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "appId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "appKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "airport"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "carrier"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "includeFlightPlan"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), java.lang.Boolean.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "maxPositions"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), java.lang.Integer.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "maxPositionAgeMinutes"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), java.lang.Integer.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sourceType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "codeType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "maxFlights"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), java.lang.Integer.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "extendedOptions"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "responseAirportTracks"));
        oper.setReturnClass(com.conducivetech.cache.flighthistory.api_internal.v2.ResponseAirportTracks.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "APIException"),
                      "com.conducivetech.cache.flighthistory.api_internal.v2.APIException",
                      new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "APIException"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("airportStatus_dep");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "appId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "appKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "airport"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "year"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "month"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "day"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "hourOfDay"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), java.lang.Integer.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "utc"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), java.lang.Boolean.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "numHours"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), java.lang.Integer.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "carrier"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "codeType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "maxFlights"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), java.lang.Integer.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "extendedOptions"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "responseAirportStatus"));
        oper.setReturnClass(com.conducivetech.cache.flighthistory.api_internal.v2.ResponseAirportStatus.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "APIException"),
                      "com.conducivetech.cache.flighthistory.api_internal.v2.APIException",
                      new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "APIException"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("airportTracks_dep");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "appId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "appKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "airport"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "carrier"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "includeFlightPlan"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), java.lang.Boolean.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "maxPositions"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), java.lang.Integer.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "maxPositionAgeMinutes"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), java.lang.Integer.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sourceType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "codeType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "maxFlights"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), java.lang.Integer.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "extendedOptions"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "responseAirportTracks"));
        oper.setReturnClass(com.conducivetech.cache.flighthistory.api_internal.v2.ResponseAirportTracks.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "APIException"),
                      "com.conducivetech.cache.flighthistory.api_internal.v2.APIException",
                      new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "APIException"), 
                      true
                     ));
        _operations[3] = oper;

    }

    public AirportServicePortBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public AirportServicePortBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public AirportServicePortBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", ">appendices>airlines");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.AirlineV1[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "airlineV1");
            qName2 = new javax.xml.namespace.QName("", "airline");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", ">appendices>airports");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.AirportV1[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "airportV1");
            qName2 = new javax.xml.namespace.QName("", "airport");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", ">appendices>equipments");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.EquipmentV1[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "equipmentV1");
            qName2 = new javax.xml.namespace.QName("", "equipment");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", ">flightStatusesResponse>flightStatuses");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.FlightStatusV2[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "flightStatusV2");
            qName2 = new javax.xml.namespace.QName("", "flightStatus");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", ">flightStatusUpdateV2>updatedDateFields");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.FlightStatusUpdatedDateV2[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "flightStatusUpdatedDateV2");
            qName2 = new javax.xml.namespace.QName("", "updatedDateField");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", ">flightStatusUpdateV2>updatedTextFields");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.FlightStatusUpdatedTextV2[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "flightStatusUpdatedTextV2");
            qName2 = new javax.xml.namespace.QName("", "updatedTextField");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", ">flightStatusV2>codeshares");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.CodeshareV2[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "codeshareV2");
            qName2 = new javax.xml.namespace.QName("", "codeshare");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", ">flightStatusV2>flightStatusUpdates");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.FlightStatusUpdateV2[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "flightStatusUpdateV2");
            qName2 = new javax.xml.namespace.QName("", "flightStatusUpdate");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", ">flightStatusV2>irregularOperations");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.IrregularOperationV2[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "irregularOperationV2");
            qName2 = new javax.xml.namespace.QName("", "irregularOperation");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", ">flightTracksResponse>flightTracks");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.FlightTrackV2[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "flightTrackV2");
            qName2 = new javax.xml.namespace.QName("", "flightTrack");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", ">flightTrackV2>irregularOperations");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.IrregularOperationV2[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "irregularOperationV2");
            qName2 = new javax.xml.namespace.QName("", "irregularOperation");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", ">flightTrackV2>positions");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.PositionV2[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "positionV2");
            qName2 = new javax.xml.namespace.QName("", "position");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", ">flightTrackV2>waypoints");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.WaypointV2[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "waypointV2");
            qName2 = new javax.xml.namespace.QName("", "waypoint");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", ">scheduleDataV2>downlines");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.DownlineFlightV2[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "downlineFlightV2");
            qName2 = new javax.xml.namespace.QName("", "downline");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", ">scheduleDataV2>uplines");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.UplineFlightV2[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "uplineFlightV2");
            qName2 = new javax.xml.namespace.QName("", "upline");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "airlineV1");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.AirlineV1.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "airportResourcesV2");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.AirportResourcesV2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "airportV1");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.AirportV1.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "APIException");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.APIException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "apiResponseError");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.ApiResponseError.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "appendices");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.Appendices.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "codeshareV2");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.CodeshareV2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "confirmedIncident");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.ConfirmedIncident.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "dateInfoV2");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.DateInfoV2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "delaysV2");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.DelaysV2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "downlineFlightV2");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.DownlineFlightV2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "equipmentV1");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.EquipmentV1.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "flightDurationsV2");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.FlightDurationsV2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "flightEquipmentV2");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.FlightEquipmentV2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "flightStatusesResponse");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.FlightStatusesResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "flightStatusUpdatedDateV2");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.FlightStatusUpdatedDateV2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "flightStatusUpdatedTextV2");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.FlightStatusUpdatedTextV2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "flightStatusUpdateV2");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.FlightStatusUpdateV2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "flightStatusV2");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.FlightStatusV2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "flightTracksResponse");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.FlightTracksResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "flightTrackV2");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.FlightTrackV2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "irregularOperationV2");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.IrregularOperationV2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "operationalTimesV2");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.OperationalTimesV2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "positionV2");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.PositionV2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "requestAirportStatus");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.RequestAirportStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "requestAirportTracks");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.RequestAirportTracks.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "requestBase");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.RequestBase.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "requestedAirlineV1");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.RequestedAirlineV1.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "requestedAirportV1");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.RequestedAirportV1.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "requestedBoolean");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.RequestedBoolean.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "requestedDate");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.RequestedDate.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "requestedInteger");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.RequestedInteger.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "requestedString");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.RequestedString.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "responseAirportStatus");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.ResponseAirportStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "responseAirportTracks");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.ResponseAirportTracks.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "responseImpl");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.ResponseImpl.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "scheduleDataV2");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.ScheduleDataV2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "uplineFlightV2");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.UplineFlightV2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "waypointV2");
            cachedSerQNames.add(qName);
            cls = com.conducivetech.cache.flighthistory.api_internal.v2.WaypointV2.class;
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

    public com.conducivetech.cache.flighthistory.api_internal.v2.ResponseAirportStatus airportStatus_arr(java.lang.String appId, java.lang.String appKey, java.lang.String airport, int year, int month, int day, java.lang.Integer hourOfDay, java.lang.Boolean utc, java.lang.Integer numHours, java.lang.String carrier, java.lang.String codeType, java.lang.Integer maxFlights, java.lang.String extendedOptions) throws java.rmi.RemoteException, com.conducivetech.cache.flighthistory.api_internal.v2.APIException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "airportStatus_arr"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {appId, appKey, airport, new java.lang.Integer(year), new java.lang.Integer(month), new java.lang.Integer(day), hourOfDay, utc, numHours, carrier, codeType, maxFlights, extendedOptions});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.conducivetech.cache.flighthistory.api_internal.v2.ResponseAirportStatus) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.conducivetech.cache.flighthistory.api_internal.v2.ResponseAirportStatus) org.apache.axis.utils.JavaUtils.convert(_resp, com.conducivetech.cache.flighthistory.api_internal.v2.ResponseAirportStatus.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.conducivetech.cache.flighthistory.api_internal.v2.APIException) {
              throw (com.conducivetech.cache.flighthistory.api_internal.v2.APIException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.conducivetech.cache.flighthistory.api_internal.v2.ResponseAirportTracks airportTracks_arr(java.lang.String appId, java.lang.String appKey, java.lang.String airport, java.lang.String carrier, java.lang.Boolean includeFlightPlan, java.lang.Integer maxPositions, java.lang.Integer maxPositionAgeMinutes, java.lang.String sourceType, java.lang.String codeType, java.lang.Integer maxFlights, java.lang.String extendedOptions) throws java.rmi.RemoteException, com.conducivetech.cache.flighthistory.api_internal.v2.APIException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "airportTracks_arr"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {appId, appKey, airport, carrier, includeFlightPlan, maxPositions, maxPositionAgeMinutes, sourceType, codeType, maxFlights, extendedOptions});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.conducivetech.cache.flighthistory.api_internal.v2.ResponseAirportTracks) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.conducivetech.cache.flighthistory.api_internal.v2.ResponseAirportTracks) org.apache.axis.utils.JavaUtils.convert(_resp, com.conducivetech.cache.flighthistory.api_internal.v2.ResponseAirportTracks.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.conducivetech.cache.flighthistory.api_internal.v2.APIException) {
              throw (com.conducivetech.cache.flighthistory.api_internal.v2.APIException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.conducivetech.cache.flighthistory.api_internal.v2.ResponseAirportStatus airportStatus_dep(java.lang.String appId, java.lang.String appKey, java.lang.String airport, int year, int month, int day, java.lang.Integer hourOfDay, java.lang.Boolean utc, java.lang.Integer numHours, java.lang.String carrier, java.lang.String codeType, java.lang.Integer maxFlights, java.lang.String extendedOptions) throws java.rmi.RemoteException, com.conducivetech.cache.flighthistory.api_internal.v2.APIException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "airportStatus_dep"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {appId, appKey, airport, new java.lang.Integer(year), new java.lang.Integer(month), new java.lang.Integer(day), hourOfDay, utc, numHours, carrier, codeType, maxFlights, extendedOptions});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.conducivetech.cache.flighthistory.api_internal.v2.ResponseAirportStatus) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.conducivetech.cache.flighthistory.api_internal.v2.ResponseAirportStatus) org.apache.axis.utils.JavaUtils.convert(_resp, com.conducivetech.cache.flighthistory.api_internal.v2.ResponseAirportStatus.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.conducivetech.cache.flighthistory.api_internal.v2.APIException) {
              throw (com.conducivetech.cache.flighthistory.api_internal.v2.APIException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.conducivetech.cache.flighthistory.api_internal.v2.ResponseAirportTracks airportTracks_dep(java.lang.String appId, java.lang.String appKey, java.lang.String airport, java.lang.String carrier, java.lang.Boolean includeFlightPlan, java.lang.Integer maxPositions, java.lang.Integer maxPositionAgeMinutes, java.lang.String sourceType, java.lang.String codeType, java.lang.Integer maxFlights, java.lang.String extendedOptions) throws java.rmi.RemoteException, com.conducivetech.cache.flighthistory.api_internal.v2.APIException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://v2.api_internal.flighthistory.cache.conducivetech.com/", "airportTracks_dep"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {appId, appKey, airport, carrier, includeFlightPlan, maxPositions, maxPositionAgeMinutes, sourceType, codeType, maxFlights, extendedOptions});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.conducivetech.cache.flighthistory.api_internal.v2.ResponseAirportTracks) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.conducivetech.cache.flighthistory.api_internal.v2.ResponseAirportTracks) org.apache.axis.utils.JavaUtils.convert(_resp, com.conducivetech.cache.flighthistory.api_internal.v2.ResponseAirportTracks.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.conducivetech.cache.flighthistory.api_internal.v2.APIException) {
              throw (com.conducivetech.cache.flighthistory.api_internal.v2.APIException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
