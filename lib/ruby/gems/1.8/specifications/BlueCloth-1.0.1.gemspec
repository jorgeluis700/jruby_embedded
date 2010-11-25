# -*- encoding: utf-8 -*-

Gem::Specification.new do |s|
  s.name = %q{BlueCloth}
  s.version = "1.0.1"

  s.required_rubygems_version = Gem::Requirement.new(">= 0") if s.respond_to? :required_rubygems_version=
  s.authors = ["Michael Granger"]
  s.autorequire = %q{bluecloth}
  s.date = %q{2009-07-15}
  s.email = %q{ged@FaerieMUD.org}
  s.files = ["utils.rb", "tests/bctestcase.rb", "tests/data/antsugar.txt", "tests/data/hr-dos.txt", "tests/data/ml-announce.txt", "tests/data/re-overflow.txt", "tests/data/re-overflow2.txt", "tests/00_Class.tests.rb", "tests/05_Markdown.tests.rb", "tests/10_Bug.tests.rb", "tests/15_Contrib.tests.rb", "test.rb", "README", "CHANGES", "LICENSE", "lib/bluecloth.rb", "install.rb", "bin/bluecloth"]
  s.homepage = %q{http://deveiate.org/projects/BlueCloth}
  s.require_paths = ["lib"]
  s.requirements = ["strscan", "logger"]
  s.rubyforge_project = %q{deveiate}
  s.rubygems_version = %q{1.3.6}
  s.summary = %q{BlueCloth is a Ruby implementation of Markdown, a text-to-HTML conversion tool for web writers. Markdown allows you to write using an easy-to-read, easy-to-write plain text format, then convert it to structurally valid XHTML (or HTML).}
  s.test_files = ["tests/00_Class.tests.rb", "tests/05_Markdown.tests.rb", "tests/10_Bug.tests.rb", "tests/15_Contrib.tests.rb"]

  if s.respond_to? :specification_version then
    current_version = Gem::Specification::CURRENT_SPECIFICATION_VERSION
    s.specification_version = 3

    if Gem::Version.new(Gem::RubyGemsVersion) >= Gem::Version.new('1.2.0') then
    else
    end
  else
  end
end
