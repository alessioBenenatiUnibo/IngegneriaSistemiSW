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
with Diagram('prodconsArch', show=False, outformat='png', graph_attr=graphattr) as diag:
  with Cluster('env'):
     sys = Custom('','./qakicons/system.png')
### see https://renenyffenegger.ch/notes/tools/Graphviz/attributes/label/HTML-like/index
     with Cluster('ctxprodcons', graph_attr=nodeattr):
          cons=Custom('cons','./qakicons/symActorSmall.png')
          prod0=Custom('prod0','./qakicons/symActorSmall.png')
          prod1=Custom('prod1','./qakicons/symActorSmall.png')
     prod1 >> Edge(color='magenta', style='solid', decorate='true', label='<infoReq &nbsp; >',  fontcolor='magenta') >> cons
     prod0 >> Edge(color='magenta', style='solid', decorate='true', label='<infoReq &nbsp; >',  fontcolor='magenta') >> cons
     prod1 >> Edge(color='blue', style='solid',  decorate='true', label='<infoDis &nbsp; >',  fontcolor='blue') >> cons
     prod0 >> Edge(color='blue', style='solid',  decorate='true', label='<infoDis &nbsp; >',  fontcolor='blue') >> cons
diag
