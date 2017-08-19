<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
    <title>TEGSOFT NetData</title>	
	<link href="css/main.css" rel="stylesheet">
	
	<script>
	    //var netdataTheme = 'default'; // this is white	
	    var netdataTheme = 'slate'; // this is dark	
	    var netdataNoBootstrap = true;
    </script>


<script type="text/javascript" src="http://192.168.47.15:19999/dashboard.js"></script>

<link rel="stylesheet" type="text/css" href="https://my-netdata.io/css/font-awesome.min.css?v4.7.0">

<link rel="stylesheet" type="text/css" href="https://my-netdata.io/dashboard.slate.css?v20170605-2">

	
</head>
<body>


<h2>TEGSOFT SERVER STATICS</h2>

<!-- MAIN SERVER STATICS   -->
<a href="http://192.168.47.15:19999">
<div class="netdata-chart-row">
            <div class="netdata-container" 
                style="margin-right: 10px; width: 81px; height: 140px;" 
                data-netdata="system.swap" 
                data-dimensions="used" 
                data-append-options="percentage" 
                data-chart-library="easypiechart" 
                data-title="Used Swap" 
                data-units="%" 
                data-easypiechart-max-value="100" 
                data-width="8%" 
                data-before="0" 
                data-after="-360" 
                data-points="360" 
                data-colors="#DD4400" 
                role="application">
            </div>
            <div class="netdata-container" 
                style="margin-right: 10px; width: 101px; height: 200px;" 
                data-netdata="system.io" 
                data-dimensions="in" 
                data-chart-library="easypiechart" 
                data-title="Disk Read" 
                data-width="10%" 
                data-before="0" 
                data-after="-360" 
                data-points="360" 
                role="application">
            </div>
            <div class="netdata-container" 
                style="margin-right: 10px; width: 101px; height: 200px;" 
                data-netdata="system.io" 
                data-dimensions="out" 
                data-chart-library="easypiechart" 
                data-title="Disk Write" 
                data-width="10%" 
                data-before="0" 
                data-after="-360" 
                data-points="360" 
                role="application">
            </div>
            <div style="width: 18%; height: 180px;" 
                class="netdata-container" 
                data-netdata="system.cpu" 
                data-chart-library="gauge"
                data-title="ARGE 15" 
                data-units="%" 
                data-gauge-max-value="100" 
                data-width="18%" 
                data-after="-360" 
                data-points="360" 
                data-colors="#22AA99" 
                role="application">
            </div>
            <div class="netdata-container" 
                style="margin-right: 10px; width: 101px; height: 200px;" 
                data-netdata="system.ipv4" 
                data-dimensions="received" 
                data-chart-library="easypiechart" 
                data-title="IPv4 Inbound" 
                data-width="10%" 
                data-before="0" 
                data-after="-360" 
                data-points="360" 
                role="application">
            </div>
            <div class="netdata-container" 
                style="margin-right: 10px; width: 101px; height: 200px;" 
                data-netdata="system.ipv4" 
                data-dimensions="sent" 
                data-chart-library="easypiechart" 
                data-title="IPv4 Outbound" 
                data-width="10%" 
                data-before="0" 
                data-after="-360" 
                data-points="360" 
                role="application">
            </div>
            <div class="netdata-container" 
                style="margin-right: 10px; width: 81px; height: 150px;" 
                data-netdata="system.ram" 
                data-dimensions="used|buffers|active|wired" 
                data-append-options="percentage" 
                data-chart-library="easypiechart" 
                data-title="Used RAM" 
                data-units="%" 
                data-easypiechart-max-value="100" 
                data-width="8%" 
                data-after="-360" 
                data-points="360" 
                data-colors="#EE9911" 
                role="application">
            </div>
        </div></a>
<!-- MAIN SERVER END -->


<div class="content" >
        <div class="container" style="text-align: center; margin-top:75px">
        
			<c:forEach items="${servers}" var="server">							
				<div class="mygauge-combo">				
	                <div class="mygauge">
	                		        <a href="http://${server.ipAddress}:59999">
							        <div style="margin-right: 10px; width: 20%;"  
							            class="netdata-container-gauge" 
							            data-host="http://${server.ipAddress}:59999"
							            data-netdata="system.cpu" 
							            data-chart-library="gauge" 
							            data-title="${server.name}" data-units="%" 
							            data-gauge-max-value="100" 
							            data-width="100%" 
							            data-after="-360" 
							            data-points="360" 
							            data-colors="#AA5555" 
							            role="application">							      
							        </div></a>
	                </div>	                
           		</div> 				
			</c:forEach>       
			  
        </div>    
</div>
</body>
</html>