### conda install diagrams
from diagrams import Cluster, Diagram, Edge
from diagrams.custom import Custom
import os
os.environ['PATH'] += os.pathsep + 'C:/Program Files/Graphviz/bin/'

graphattr = {     #https://www.graphviz.org/doc/info/attrs.html
    'fontsize': '22',
}

nodeattr = {   
    'fontsize': '22',
    'bgcolor': 'lightyellow'
}

eventedgeattr = {
    'color': 'red',
    'style': 'dotted'
}
with Diagram('cold_storage_serviceArch', show=False, outformat='png', graph_attr=graphattr) as diag:
  with Cluster('env'):
     sys = Custom('','./qakicons/system.png')
### see https://renenyffenegger.ch/notes/tools/Graphviz/attributes/label/HTML-like/index
     with Cluster('ctx_cold_storage_service', graph_attr=nodeattr):
          cold_storage_service=Custom('cold_storage_service','./qakicons/symActorSmall.png')
          ticket_manager=Custom('ticket_manager','./qakicons/symActorSmall.png')
          indoor=Custom('indoor','./qakicons/symActorSmall.png')
          driver_mock=Custom('driver_mock','./qakicons/symActorSmall.png')
     driver_mock >> Edge(color='magenta', style='solid', decorate='true', label='<store_request &nbsp; >',  fontcolor='magenta') >> cold_storage_service
     indoor >> Edge(color='magenta', style='solid', decorate='true', label='<validate_ticket_request &nbsp; >',  fontcolor='magenta') >> ticket_manager
diag
