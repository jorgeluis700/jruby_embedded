=begin 
require 'rubygems'
require 'yaml'

require 'active_record'
require 'active_record/connection_adapters/jdbc_adapter'
require 'sqljdbc.jar' # para mssql

#ds_config = YAML::load_file('ds-mssql.yaml')
#ds_config = YAML::load_file('ds-mysql.yaml')
 
ActiveRecord::Base.establish_connection(ds_config)

class Store < ActiveRecord::Base
  set_table_name 'Sales.Store'
end

class SysConfig < ActiveRecord::Base
  set_table_name "sysconfig"
end
=end

require 'java'

import com.mydomain.util.LogPrintStream
import com.mydomain.messages.action.RubyProxy

# Modulo de logueo simple
module Log
  def log(message)
    puts Time.now.to_s + ': ' + message
  end
  def log_simple(message)
    puts message
  end
end

# Clase para test
class HelloWorld
  include Log
  
  def hello
    begin
      test
      log class_path
      find_jruby_home
    rescue Exception => error
        log error
    end
  end
  
  def find_jruby_home
    # service lookup
    ic = javax.naming.InitialContext.new
    jrs = ic.lookup('SeamJRuby/JRubyServiceBean/local')
    
    # query
    em = jrs.entity_manager
    query = "from SysConfig s where s.configKey = :configKey"
    config = em.create_query(query).set_parameter('configKey', 'jruby.home').single_result
    config.config_value
  end
  
  def test
    rp = RubyProxy.new nil, nil
  end
  
  def class_path
    java.lang.System.get_property 'java.class.path'
  end
  
end

if __FILE__ == $0
  h = HelloWorld.new
  puts h.hello	
end  