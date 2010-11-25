# -*- encoding: utf-8 -*-

Gem::Specification.new do |s|
  s.name = %q{mongrel_jcluster}
  s.version = "0.0.1"

  s.required_rubygems_version = nil if s.respond_to? :required_rubygems_version=
  s.authors = ["Bradley Taylor & Ola Bini"]
  s.cert_chain = nil
  s.date = %q{2007-05-06}
  s.default_executable = %q{mongrel_jcluster_ctl}
  s.description = %q{Mongrel plugin that provides commands for managing multiple Mongrel processes in a JVM.}
  s.executables = ["mongrel_jcluster_ctl"]
  s.extra_rdoc_files = ["README"]
  s.files = ["COPYING", "LICENSE", "README", "Rakefile", "bin/mongrel_jcluster_ctl", "lib/mongrel_jcluster", "lib/mongrel_jcluster/init.rb", "tools/rakehelp.rb", "resources/defaults.yaml", "resources/mongrel_jcluster"]
  s.require_paths = ["lib"]
  s.required_ruby_version = Gem::Requirement.new("> 0.0.0")
  s.rubygems_version = %q{1.3.6}
  s.summary = %q{Mongrel plugin that provides commands for managing multiple Mongrel processes in a JVM.}

  if s.respond_to? :specification_version then
    current_version = Gem::Specification::CURRENT_SPECIFICATION_VERSION
    s.specification_version = 1

    if Gem::Version.new(Gem::RubyGemsVersion) >= Gem::Version.new('1.2.0') then
      s.add_runtime_dependency(%q<gem_plugin>, [">= 0.2.1"])
      s.add_runtime_dependency(%q<mongrel>, [">= 0.3.13.4"])
    else
      s.add_dependency(%q<gem_plugin>, [">= 0.2.1"])
      s.add_dependency(%q<mongrel>, [">= 0.3.13.4"])
    end
  else
    s.add_dependency(%q<gem_plugin>, [">= 0.2.1"])
    s.add_dependency(%q<mongrel>, [">= 0.3.13.4"])
  end
end
